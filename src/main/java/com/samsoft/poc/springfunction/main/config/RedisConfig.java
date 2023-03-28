/**
 * 
 */
package com.samsoft.poc.springfunction.main.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pradh
 *
 */
@Configuration
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String redisServer;

	@Bean
	public RedissonClient redissonClient() {
		Config config = new Config();
		config.useSingleServer().setAddress(redisServer).setConnectTimeout(60000).setTimeout(60000);
		return Redisson.create(config);
	}

}
