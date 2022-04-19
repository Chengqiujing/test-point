package com.test.demo.web;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * @author：chengqj
 * @createDate：2022/4/19 13:24
 * ©北京数字认证股份有限公司 2022
 * @description:
 */
@Component
public class SpringSchedule implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> {
                    /*
                    验证一下报错是否还执行
                    结果：报错是可以执行得
                     */
                    int a = 1/0;
                },
                triggerContext -> {
                    return new CronTrigger("0/1 * * * * ?").nextExecutionTime(triggerContext);
                }
        );
    }
}
