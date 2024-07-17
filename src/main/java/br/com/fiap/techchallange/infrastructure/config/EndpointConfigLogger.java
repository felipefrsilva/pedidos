package br.com.fiap.techchallange.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class EndpointConfigLogger {
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Bean
    public CommandLineRunner logEndpoints() {
        return args -> requestMappingHandlerMapping.getHandlerMethods()
                .forEach((key, value) -> System.out.println(key + " " + value));
    }
}
