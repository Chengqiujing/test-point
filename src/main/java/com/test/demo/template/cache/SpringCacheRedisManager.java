package com.test.demo.template.cache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: SpringCacheTest.java
 * @包 路 径： com.test.demo.template.cache
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/12/6 10:24
 */
@Service
@CacheConfig(cacheNames = {"test"})
public class SpringCacheRedisManager {

    /**
     * 关于spring cache的测试
     *
     * 使用：可见官网 https://docs.spring.io/spring-boot/docs/current/reference/html/io.html#io.caching.provider.redis
     *      官网 https://docs.spring.io/spring-framework/docs/5.3.13/reference/html/integration.html#cache-annotations
     *
     *      使用通常会根据连入的环境，产生一个cacheManager，并自动配置，也可在配置文件中以 spring.cache.* 来配置，例如，spring.cache
     *
     *      应为不灵活所以尽量配置cacheManager,可以说是牺牲灵活性来提升代码的简洁度
     *
     * 结论：
     * 1.spring cache使用起来不灵活，只是在不侵入代码上做的比较好，其他的，感觉使用起来感受不好
     *
     * @return
     */


    @Cacheable(value = "name")
    public String getCache(){
        return "null";
    }

    @CachePut()
    public String putCache(String name){
        return name;
    }

    @CachePut(value = "name")
    public String updateCache(String name){
        return name;
    }

    @CacheEvict(value = "name")
    public void deleteCache(){

    }

    @CachePut(value = "map")
    public Map putMap(){
        Map<String, String> map = new HashMap<>();
        map.put("123","123");
        return map;
    }

}
