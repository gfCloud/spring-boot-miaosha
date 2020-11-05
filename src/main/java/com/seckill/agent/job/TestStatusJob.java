package com.seckill.agent.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestStatusJob {

    @SuppressWarnings("unused")
    @XxlJob("testPrint")
    public ReturnT<String> testPrint() {
        XxlJobLogger.log("XXL-JOB, 引入打印测试.");
        System.out.println("log = " + "打印测试！！！");
        return ReturnT.SUCCESS;
    }
}
