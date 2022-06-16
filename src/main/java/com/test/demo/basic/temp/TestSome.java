package com.test.demo.basic.temp;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author：chengqj
 * @createDate：2022/5/16 17:25
 * ©北京数字认证股份有限公司 2022
 * @description:
 */
public class TestSome {
    public static void main(String[] args) {
//        2022-04-26 18:31:28
        LocalDateTime of = LocalDateTime.of(2022, 4, 26, 18, 31, 28);
        Instant instant = of.toInstant(ZoneOffset.UTC);
        System.out.println(instant.toEpochMilli());

        /*
        json解析对应java中的Object对象的时候，会将对象解析成JSONObject，接下来如何处理？
         */
//        TTT ttt = JSONObject.parseObject("{\"cpu\":[{\"name\":\"qilin\",\"id\":\"xa1111\"}]}", TTT.class);
        TTT ttt = JSONObject.parseObject("{\"cpu\": {\"name\":\"haisi\"}}", TTT.class);
        String simpleName = ttt.getCpu().getClass().getSimpleName();
        System.out.println(simpleName);
        System.out.println(((JSONObject)ttt.getCpu()).toJavaObject(CPU.class));
        System.out.println( null instanceof String);
    }

    @Data
    public static class TTT{
        private Object cpu;
    }

    @Data
    public static class CPU {
        /**
         * CPU名称
         */
        private String name;
        /**
         * COU序号
         */
        private String id;
    }
}
