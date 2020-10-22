package com.seckill.agent.common.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.seckill.agent.common.mapper.MyMapper;
import com.seckill.agent.common.service.ICommonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 通用service实现
 *
 * @author gaoFan
 */
@SuppressWarnings("unused")
@Log4j2
public class CommonServiceImpl<T, E> implements ICommonService<T, E> {
    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getCurrentEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    public MyMapper<T> mapper;


    @Override
    public T createOrUpdate(T t, boolean isUpdate) {
        boolean isSuccess = false;
        if (isUpdate) {
            if (mapper.updateByPrimaryKeySelective(t) > 0) {
                isSuccess = true;
            }
        } else {
            int insert = mapper.insertSelective(t);
            if (insert > 0) {
                isSuccess = true;
            }
        }
        if (isSuccess) {
            return t;
        }
        return null;
    }

    @Override
    public Integer insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    public Integer insertList(List<T> t) {
        return mapper.insertList(t);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Integer updateByPrimaryKeySelective(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public Integer updateByPrimaryKey(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public Integer updateAllByPrimaryKeySelective(List<T> t) {
        Integer count = 0;
        for (T t1 : t) {
            count += updateByPrimaryKeySelective(t1);
        }
        return count;
    }

    @Override
    public PageInfo<T> selectByNonNullFieldUsedAnd(T t, int pageNum, int pageSize) {
        PageMethod.startPage(pageNum, pageSize, true, false, false);
        return new PageInfo<>(mapper.select(t));
    }

    @Override
    public List<T> selectByNonNullFieldUsedAnd(T t) {
        return mapper.select(t);
    }

    @Override
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    @Override
    public PageInfo<T> selectByNonNullFieldUsedOr(T t, int pageNum, int pageSize) {
        Example example = new Example(t.getClass());
        example.createCriteria().orEqualTo(t);
        PageMethod.startPage(pageNum, pageSize, true, false, false);
        return new PageInfo<>(mapper.selectByExample(example));
    }

    @Override
    public List<T> selectInByProperty(String property, Collection<?> ids) {
        Example example = new Example(getCurrentEntityClass());
        example.createCriteria().andIn(property, ids);
        return mapper.selectByExample(example);
    }

    @Override
    public PageInfo<T> selectOrderByFields(T t, int pageNum, int pageSize, String sortType, String... fields) {
        if (null == t) {
            return null;
        }
        Example example = new Example(t.getClass());
        String join = String.join(" " + sortType + " ,", fields);
        example.setOrderByClause(join + " " + sortType + " ");
        example.createCriteria().andEqualTo(t);
        PageMethod.startPage(pageNum, pageSize, true, false, false);
        return new PageInfo<>(mapper.selectByExample(example));
    }

    @Override
    public List<T> selectAllOrderByFields(T t, String sortType, String... fields) {
        if (null == t) {
            return Collections.emptyList();
        }
        Example example = new Example(t.getClass());
        String join = String.join(",", fields);
        example.setOrderByClause(join + " " + sortType + " ");
        example.createCriteria().andEqualTo(t);
        return mapper.selectByExample(example);
    }

    @Override
    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }


    public void rollBackOnly() {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    @Override
    public PageInfo<T> selectAll(int pageNum, int pageSize) {
        PageMethod.startPage(pageNum, pageSize, true, false, false);
        return new PageInfo<>(mapper.selectAll());
    }


    @Override
    public void deleteByProperty(T t) {
        mapper.delete(t);
    }

    @Override
    public Integer deleteList(List<E> eList) {
        for (E e : eList) {
            mapper.deleteByPrimaryKey(e);
        }
        return eList.size();
    }

    @Override
    public int selectCount(T t) {
        return mapper.selectCount(t);
    }

    @Override
    public List<T> selectByNonNullField(T t) {
        return mapper.select(t);
    }


}

