package com.servicio.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringcloudServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServicioItemApplication.class, args);
	}

}
