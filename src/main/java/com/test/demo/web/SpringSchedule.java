package com.test.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> {
                    /*
                    验证一下报错是否还执行
                    结果：报错是可以执行得
                     */
//                    int a = 1/0;
                    doProcess();
                },
                triggerContext -> {
                    return new CronTrigger("0/3 * * * * ?").nextExecutionTime(triggerContext);
                }
        );
    }



    public void doProcess(){
        System.out.println("进来：" + Thread.currentThread().getName() + " t-id:" + Thread.currentThread().getId());


        try {

            Thread.sleep(1000000000);
            System.out.println("finish!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
