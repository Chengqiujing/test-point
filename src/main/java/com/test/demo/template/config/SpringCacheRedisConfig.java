package com.test.demo.template.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: SpringCacheRedisConfig.java
 * @包 路 径： com.test.demo.template.config
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/12/6 10:43
 */
@Configuration
public class SpringCacheRedisConfig {

    /**
     * 配置缓存管理器
     * @param factory Redis 线程安全连接工厂
     * @return 缓存管理器
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        // 生成两套默认配置，通过 Config 对象即可对缓存进行自定义配置
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                // 设置过期时间 10 分钟
                .entryTtl(Duration.ofMinutes(10))
                // 设置缓存前缀
//                .prefixKeysWith("cache:user:")
                // 禁止缓存 null 值
                .disableCachingNullValues()
                // 设置 key 序列化
                .serializeKeysWith(keyPair())
                // 设置 value 序列化
                .serializeValuesWith(valuePair());
        // 返回 Redis 缓存管理器
        return RedisCacheManager.builder(factory)
                .cacheDefaults(cacheConfig)
//                .withCacheConfiguration("user", cacheConfig) // 只针对某一个cache起作用，这里一定注意
                .build();

    }

    /**
     * 配置键序列化
     * @return StringRedisSerializer
     */
    private RedisSerializationContext.SerializationPair<String> keyPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
    }

    /**
     * 配置值序列化，使用 GenericJackson2JsonRedisSerializer 替换默认序列化
     * @return GenericJackson2JsonRedisSerializer
     */
    private RedisSerializationContext.SerializationPair<Object> valuePair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    }

}
