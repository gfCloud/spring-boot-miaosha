package com.miaosha.agent.listener;

import com.miaosha.agent.config.AlipayProperties;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lr-qixin
 * @date 2020-10-15
 */
@Component
public class PropertiesListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        AlipayProperties.loadproperties();
    }
}
