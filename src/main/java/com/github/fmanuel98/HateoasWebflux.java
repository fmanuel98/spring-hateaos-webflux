package com.github.fmanuel98;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "REST API para venda de Produtos", version = "1.0", description = "API criada com o objectivo de apender sobre Open API e Web Flux"))
public class HateoasWebflux {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(HateoasWebflux.class, args);
	}
}
