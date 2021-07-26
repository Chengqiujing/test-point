package com.test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;


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
