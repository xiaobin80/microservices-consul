package com.tdtc.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringcloudUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudUserServiceApplication.class, args);
	}
}
