package com.ismael.acodike.SpringPedidosAcodike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com/ismael/acodike/SpringPedidosAcodike/domain")
public class SpringPedidosAcodikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPedidosAcodikeApplication.class, args);
	}

}
