package com.seckill.agent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageInfoResp<T> {
    private Long total;
    private List<T> list;
}
