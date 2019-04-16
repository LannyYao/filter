package com.lanny.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Lanny Yao
 * @date 4/12/2019 11:32 AM
 */
@Slf4j
@Component
public class SchedulerDisableConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("我的父容器为：" + event.getApplicationContext().getParent());
        System.out.println("初始化时我被调用了。");
    }
}
