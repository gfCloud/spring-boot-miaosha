package com.seckill.agent.common.service;

import com.github.pagehelper.PageInfo;

import java.util.Collection;
import java.util.List;

/**
 * @author gaoFan
 */
@SuppressWarnings("unused")
public interface ICommonService<T, E> {
    /**
     * 获取当前操作实体的class
     *
     * @return 当前操作实体的class
     */
    Class<T> getCurrentEntityClass();

    /**
     * insertSelective or update
     *
     * @param t        实体
     * @param isUpdate 是更新还是插入
     * @return 成功返回t（insert成功后，主键回set到主键字段中。）,失败返回null
     */
    T createOrUpdate(T t, boolean isUpdate);

    /**
     * 插入表
     *
     * @param t 实体
     * @return 返回影响的行数
     */
    Integer insertSelective(T t);

    /**
     * 批量插入表
     *
     * @param t 实体
     * @return 返回影响的行数
     */
    Integer insertList(List<T> t);

    /**
     * 查询所有
     *
     * @return 返回所有数据
     */
    List<T> selectAll();

    /**
     * 根据主键更新属性不为null的值
     *
     * @param t 实体对象
     * @return 返回影响的行数
     */
    Integer updateByPrimaryKeySelective(T t);

    /**
     * 根据主键更新所有属性，null字段会被更新成null
     *
     * @param t 实体对象
     * @return 返回影响的行数
     */
    Integer updateByPrimaryKey(T t);

    /**
     * 批量根据主键更新属性不为null的值
     *
     * @param t 实体对象
     * @return 返回影响的行数
     */
    Integer updateAllByPrimaryKeySelective(List<T> t);

    /**
     * 根据非空字段 分页查询
     *
     * @param t        实体
     * @param pageNum  页码
     * @param pageSize 一页的行数
     * @return 含分页信息的列表查询
     */
    PageInfo<T> selectByNonNullFieldUsedAnd(T t, int pageNum, int pageSize);

    /**
     * 根据非空字段 分页查询
     *
     * @param t 实体
     * @return 列表
     */
    List<T> selectByNonNullFieldUsedAnd(T t);

    /**
     * 根据非空字段用OR连接查询
     *
     * @param t        实体
     * @param pageNum  页码
     * @param pageSize 每页行数
     * @return 分页结果集
     */
    PageInfo<T> selectByNonNullFieldUsedOr(T t, int pageNum, int pageSize);

    /**
     * 根据实体非空字段查询数据，并通过指定字段进行排序
     *
     * @param t        实体
     * @param pageNum  页码
     * @param pageSize 行数
     * @param sortType 排序方式，使用DbConstant.ASC，DbConstant.DESC
     * @param fields   排序字段，字段名使用数据库中的字段名，不要使用实体中的驼峰字段名
     * @return 结果
     */
    PageInfo<T> selectOrderByFields(T t, int pageNum, int pageSize, String sortType, String... fields);

    /**
     * 查询所有，并根据指定排序类型和字段进行排序
     *
     * @param t        查询参数
     * @param sortType 排序类型
     * @param fields   排序字段
     * @return 结果集
     */
    List<T> selectAllOrderByFields(T t, String sortType, String... fields);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 结果
     */
    T selectById(Object id);

    /**
     * 根据属性名和值列表做in查询
     *
     * @param property 属性名
     * @param ids      值列表
     * @return 结果集
     */
    List<T> selectInByProperty(String property, Collection<?> ids);

    /**
     * selectAll 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return 结果集
     */
    PageInfo<T> selectAll(int pageNum, int pageSize);

    /**
     * 根据属性，删除记录
     *
     * @param t 表实体对象
     */
    void deleteByProperty(T t);

    /**
     * 删除列表
     *
     * @param eList 主键列表
     * @return eList数量
     */
    Integer deleteList(List<E> eList);

    /**
     * 根据实体参数查询一条数据
     *
     * @param t 实体参数
     * @return 结果集的第一个结果
     */
    T selectOne(T t);

    /**
     * 查询符合条件的数据总数
     *
     * @param t 条件
     * @return 总数
     */
    int selectCount(T t);

    /**
     * 根据非空字段查询
     * @param t 实体参数
     * @return 结果集
     */
    List<T> selectByNonNullField(T t);
}
