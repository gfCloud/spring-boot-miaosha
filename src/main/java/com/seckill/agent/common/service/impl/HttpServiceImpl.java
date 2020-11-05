package com.seckill.agent.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.seckill.agent.common.service.IHttpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


/**
 * @author flysg
 */
@Slf4j
@Service
public class HttpServiceImpl implements IHttpService {

    private RestTemplate restTemplate;

    @Override
    public <T> T doGet(String url, Object params, Map<String, String> headers, Class<T> respType) {
        HttpEntity<Object> request = new HttpEntity<>(buildGetParams(params), buildHeaders(headers, null));
        return restTemplate.exchange(url, HttpMethod.GET, request, respType).getBody();
    }

    @Override
    public <T> T doPost(String url, Object params, Map<String, String> headers, Class<T> respType) {
        HttpEntity<Object> request = new HttpEntity<>(buildGetParams(params), buildHeaders(headers, MediaType.APPLICATION_FORM_URLENCODED));
        return restTemplate.exchange(url, HttpMethod.POST, request, respType).getBody();
    }

    @Override
    public <T> T doPostJson(String url, Object params, Map<String, String> headers, Class<T> respType) {
        HttpHeaders httpHeaders = buildHeaders(headers, MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(JSON.toJSONString(params), httpHeaders);
        return restTemplate.exchange(url, HttpMethod.POST, request, respType).getBody();
    }

    private MultiValueMap<String, Object> buildGetParams(Object params) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        if (params != null) {
            String jsonString = JSON.toJSONString(params);
            if (StringUtils.isNotBlank(jsonString)) {
                Map<String, Object> objectMap = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>() {
                });
                if (!CollectionUtils.isEmpty(objectMap)) {
                    objectMap.forEach(map::add);
                }
            }
        }
        return map;
    }

    private HttpHeaders buildHeaders(Map<String, String> headers, MediaType mediaType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(mediaType);
        if (!CollectionUtils.isEmpty(headers)) {
            headers.forEach(httpHeaders::add);
        }
        return httpHeaders;
    }

}
