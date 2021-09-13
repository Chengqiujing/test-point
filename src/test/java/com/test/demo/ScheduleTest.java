package com.test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: ScheduleTest.java
 * @包 路 径： com.test.demo
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/9/13 22:53
 */
@SpringBootTest
public class ScheduleTest {

    @Test
    public void test(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(1);
        scheduler.initialize();
        scheduler.scheduleAtFixedRate(()->{
            System.out.println("zhixing");
        },1000*3);
    }

}
