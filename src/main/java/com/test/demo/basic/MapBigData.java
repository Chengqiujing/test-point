package com.test.demo.basic;

import org.springframework.boot.autoconfigure.mustache.MustacheResourceTemplateLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: MapBigData.java
 * @包 路 径： com.test.demo.basic
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/4/25 10:24
 */
public class MapBigData {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        String s = UUID.randomUUID().toString();
        map.put(s,1);
        for (int i = 0; i < 1000000; i++) {
            map.put(UUID.randomUUID().toString(),1);
        }
        long l = System.currentTimeMillis();
        System.out.println(l);
        Object o = map.get(s);
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        System.out.println("time: "+(l1-l));
    }
}
