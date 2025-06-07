package com.ganpati.shoppingkart;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Shopping Kart Rest API Service",
				description = "Shopping Kart Rest API Service Documentation",
				version = "v1",
				contact = @Contact(
						name = "Ganpati Roy",
						email = "ganpatikumarroy@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "GitHub link for this project",
				url = "https://github.com/GanpatiKumarRoy"
		)
)
@SpringBootApplication
public class ShoppingKartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingKartApplication.class, args);
	}
}