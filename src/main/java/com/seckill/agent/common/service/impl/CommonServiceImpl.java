package com.seckill.agent.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.agent.common.service.ICommonService;
import com.seckill.agent.dto.BasePageInfoReq;
import com.seckill.agent.dto.PageInfoResp;
import com.seckill.agent.until.BeanUtil;
import lombok.extern.log4j.Log4j2;

import java.util.stream.Collectors;

/**
 * 通用service实现
 *
 * @author gaoFan
 */
@SuppressWarnings("unused")
@Log4j2
public class CommonServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements ICommonService<T> {

    @Override
    public <D> PageInfoResp<D> pageList(BasePageInfoReq pageInfoReq, Class<D> dClass) {
        Page<T> tPage = getBaseMapper().selectPage(new Page<>(pageInfoReq.getPageNum(), pageInfoReq.getPageSize()), null);
        if (tPage != null && CollectionUtils.isNotEmpty(tPage.getRecords())) {
            return new PageInfoResp<>(tPage.getTotal(), tPage.getRecords().stream().map(r -> BeanUtil.copyPropertiesIgnoreNull(r, dClass)).collect(Collectors.toList()));
        }
        return new PageInfoResp<>(0L, null);
    }

    @Override
    public PageInfoResp<T> pageList(BasePageInfoReq pageInfoReq) {
        Page<T> tPage = getBaseMapper().selectPage(new Page<>(pageInfoReq.getPageNum(), pageInfoReq.getPageSize()), null);
        if (tPage != null && CollectionUtils.isNotEmpty(tPage.getRecords())) {
            //noinspection unchecked
            return new PageInfoResp<>(tPage.getTotal(), tPage.getRecords().stream().map(r -> (T) BeanUtil.copyPropertiesIgnoreNull(r, this.entityClass)).collect(Collectors.toList()));
        }
        return new PageInfoResp<>(0L, null);
    }

    @Override
    public PageInfoResp<T> pageListWrapper(BasePageInfoReq pageInfoReq, Class<T> dClass, QueryWrapper<T> wrapper) {
        Page<T> tPage = getBaseMapper().selectPage(new Page<>(pageInfoReq.getPageNum(), pageInfoReq.getPageSize()), wrapper);
        if (tPage != null && CollectionUtils.isNotEmpty(tPage.getRecords())) {
            return new PageInfoResp<>(tPage.getTotal(), tPage.getRecords().stream().map(r -> BeanUtil.copyPropertiesIgnoreNull(r, dClass)).collect(Collectors.toList()));
        }
        return new PageInfoResp<>(0L, null);
    }
}

