package com.smarthireai.smarthireai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableCaching
@SpringBootApplication
@EnableFeignClients
public class SmarthireaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmarthireaiApplication.class, args);
	}

}
