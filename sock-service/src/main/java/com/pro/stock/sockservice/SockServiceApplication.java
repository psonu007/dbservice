package com.pro.stock.sockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SockServiceApplication.class, args);
	}

}
