package eu.raiffaisen.accountservicerf.config;

import eu.raiffaisen.accountservicerf.exception.AccountServiceException;
import eu.raiffaisen.accountservicerf.service.AccountService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;


@Configuration
@EnableCaching
public class CacheConfig {
    private static final String EX_RATES_CACHE = "exchange-rates" ;
    @Bean
    public CacheManager cacheManager() {
        List<ConcurrentMapCache> caches = Arrays.asList(new ConcurrentMapCache(EX_RATES_CACHE));
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(caches);
//        if(cacheManager.getCache(EX_RATES_CACHE)==null){
//            throw new AccountServiceException("Cache " + EX_RATES_CACHE + " not found!");
//        }
        return cacheManager;
    }
}
