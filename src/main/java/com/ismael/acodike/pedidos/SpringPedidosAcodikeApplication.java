package com.ismael.acodike.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com/ismael/acodike/pedidos/domain")
public class SpringPedidosAcodikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPedidosAcodikeApplication.class, args);
	}

}
