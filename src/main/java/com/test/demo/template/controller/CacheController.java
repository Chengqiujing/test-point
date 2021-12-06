package com.test.demo.template.controller;

import com.test.demo.template.cache.SpringCacheRedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: CacheController.java
 * @包 路 径： com.test.demo.template.controller
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/12/6 10:49
 */
@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    SpringCacheRedisManager redisManager;

//    @GetMapping("/get")
//    public String getCache(){
//        return redisManager.getCache();
//    }

    @GetMapping("/put")
    public void putCache(String name){
        redisManager.putCache(name);
    }

    @GetMapping("/update")
    public void updateCache(String name){
        redisManager.updateCache(name);
    }

//    @GetMapping("/delete")
//    public void deleteCache(){
//        redisManager.deleteCache();
//    }
//
//
//    @GetMapping("/putMap")
//    public void putMap(){
//        redisManager.putMap();
//    }
}
