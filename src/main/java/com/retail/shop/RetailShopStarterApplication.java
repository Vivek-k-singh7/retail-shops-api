package com.retail.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@EntityScan("com.retail.shop.entity")
@EnableJpaRepositories("com.retail.shop.repository")
@SpringBootApplication(scanBasePackages="com.retail.shop")
public class RetailShopStarterApplication {

	public static void main(String[] args) {
		new SpringApplication(RetailShopStarterApplication.class).run(args);
	}

	@Bean
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}
}
