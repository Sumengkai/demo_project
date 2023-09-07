package com.example.demo_project.Config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//�`�N�Ogit

import com.github.benmanes.caffeine.cache.Caffeine;

//springframework �Ψ��X�ʽw�s���`��
//�e�����ܤ֦��@�� cacheManager �� bean
@EnableCaching
//�t�m���]�w�ɮ� ���spring boot�U��
@Configuration
public class CaffeineCacheConfig {
	@Bean
	public CacheManager CacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(
				Caffeine.newBuilder()
//				�]�w�L���ɶ�
//				1.�̫�@���g�J��
//				2.�X�ݫ�L�T�w�@�q�ɶ�
				.expireAfterAccess(600, TimeUnit.SECONDS)
//				��l�w�s�Ŷ��j�p
				.initialCapacity(100)
//				�w�s�̤j����
				.maximumSize(500));
		return cacheManager;

	}
}
