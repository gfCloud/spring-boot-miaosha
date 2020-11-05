package com.seckill.agent.common.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.agent.dto.BasePageInfoReq;
import com.seckill.agent.dto.PageInfoResp;

/**
 * @author gaoFan
 */
public interface ICommonService<T> extends IService<T> {
    /**
     * 分页查询
     * 注意：
     * 类型转换使用BeanUtil.copyProperties方式实现，已忽略null字段的复制。
     * dClass中的字段必须和entity中的字段名一致，才能正常转换。
     *
     * @param pageInfoReq 分页参数
     * @param dClass      结果集被返回类型
     * @return 分页结果集
     */
    <D> PageInfoResp<D> pageList(BasePageInfoReq pageInfoReq, Class<D> dClass);

    /**
     * 分页查询
     *
     * @param pageInfoReq 分页参数
     * @return 分页结果集
     */
    PageInfoResp<T> pageList(BasePageInfoReq pageInfoReq);


    /**
     * 根据条件分页查询
     * @param pageInfoReq 分页参数
     * @param dClass 结果集返回类型
     * @param wrapper 查询条件
     * @return 分页结果集
     */
    PageInfoResp<T> pageListWrapper(BasePageInfoReq pageInfoReq, Class<T> dClass, QueryWrapper<T> wrapper);
}
