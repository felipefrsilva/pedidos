package br.com.fiap.techchallange;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.fiap.techchallange.infrastructure.adapters",
		                       "br.com.fiap.techchallange.infrastructure.factory",
		                       "br.com.fiap.techchallange.infrastructure.config"} )
public class MainApplication {
	public static void main(String[] args) {
		System.out.println("Environment: " + System.getenv("SPRING_PROFILES_ACTIVE"));
		SpringApplication.run(MainApplication.class, args);
	}
}
