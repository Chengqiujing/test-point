package com.test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: RedisTest.java
 * @包 路 径： com.test.demo
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/7/23 16:48
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void testAbsent(){
//        stringRedisTemplate.opsForValue().setIfAbsent("aaa","bbb");
        stringRedisTemplate.opsForValue().set("bbb", "aaa");
    }

}
