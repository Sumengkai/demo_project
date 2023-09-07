package com.example.demo_project.Config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//注意是git

import com.github.benmanes.caffeine.cache.Caffeine;

//springframework 用來驅動緩存的注釋
//容器內至少有一個 cacheManager 的 bean
@EnableCaching
//配置成設定檔案 交由spring boot託管
@Configuration
public class CaffeineCacheConfig {
	@Bean
	public CacheManager CacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(
				Caffeine.newBuilder()
//				設定過期時間
//				1.最後一次寫入或
//				2.訪問後過固定一段時間
				.expireAfterAccess(600, TimeUnit.SECONDS)
//				初始緩存空間大小
				.initialCapacity(100)
//				緩存最大筆數
				.maximumSize(500));
		return cacheManager;

	}
}
