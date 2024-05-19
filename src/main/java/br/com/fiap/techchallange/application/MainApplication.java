package br.com.fiap.techchallange.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.fiap.techchallange.infrastructure.adapters.*")
@ComponentScan(basePackages = {"br.com.fiap.techchallange.infrastructure.adapters.*"})
@EntityScan("br.com.fiap.techchallange.*")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
