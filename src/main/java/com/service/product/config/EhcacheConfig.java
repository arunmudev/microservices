package com.service.product.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EhcacheConfig {

    @Bean
    public EhCacheManagerFactoryBean cacheManager(){
        return new EhCacheManagerFactoryBean();
    }

    @Bean
    public EhCacheCacheManager cacheCacheManager(){
        CacheConfiguration tesCacheAutoConfiguration = new CacheConfiguration()
                .eternal(false)
                .timeToIdleSeconds(60)
                .timeToLiveSeconds(60)
                .maxEntriesLocalHeap(10)
                .memoryStoreEvictionPolicy("LRU")
                .name("testcache");
        Cache testCache =  new Cache(tesCacheAutoConfiguration);
        cacheManager().getObject().addCache(testCache);
        return new EhCacheCacheManager(cacheManager().getObject());
    }
}
