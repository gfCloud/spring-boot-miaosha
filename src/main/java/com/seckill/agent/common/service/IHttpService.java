package com.seckill.agent.common.service;

import java.util.Map;


public interface IHttpService {
    /**
     * 执行Get请求，返回String body
     *
     * @param url      请求URL
     * @param params   请求参数，可以是任何vo对象，或者map，但不支持嵌套对象和map
     * @param headers  请求头
     * @param respType 返回值的包装类型
     * @return String body
     */
    <T> T doGet(String url, Object params, Map<String, String> headers, Class<T> respType);

    /**
     * 执行表单POST请求，返回String body
     *
     * @param url      请求URL
     * @param params   请求参数，可以是任何vo对象，或者map，但不支持嵌套对象和map
     * @param headers  请求头
     * @param respType 返回值的包装类型
     * @return 包装类型实例
     */
    <T> T doPost(String url, Object params, Map<String, String> headers, Class<T> respType);

    /**
     * 执行json POST请求，返回String body
     *
     * @param url      请求URL
     * @param params   请求参数，可以是任何vo对象，或者map，但不支持嵌套对象和map
     * @param headers  请求头
     * @param respType 返回值的包装类型
     * @return 包装类型实例
     */
    <T> T doPostJson(String url, Object params, Map<String, String> headers, Class<T> respType);
}
