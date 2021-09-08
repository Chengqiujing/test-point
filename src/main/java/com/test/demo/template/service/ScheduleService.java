package com.test.demo.template.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: ScheduleService.java
 * @包 路 径： com.test.demo.template.service
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/9/7 16:54
 */
@Configuration
@Service
@EnableScheduling
public class ScheduleService implements SchedulingConfigurer {
    private ScheduledTaskRegistrar scheduledTaskRegistrar;
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        this.scheduledTaskRegistrar = scheduledTaskRegistrar;
    }

    public void setTask(Runnable task,String cron){
        scheduledTaskRegistrar.addTriggerTask(
                task,
                triggerContext -> {
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );

//        List<TriggerTask> triggerTaskList = scheduledTaskRegistrar.getTriggerTaskList();
//        triggerTaskList.
    }



}
