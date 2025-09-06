package com.example.ZETA_Api_MongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ZetaApiMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZetaApiMongoDbApplication.class, args);
	}

}
