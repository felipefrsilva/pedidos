package br.com.fiap.techchallange.infrastructure.config.gateways.services;

import br.com.fiap.techchallange.adapters.gateways.service.IDisplayMonitor;
import br.com.fiap.techchallange.infrastructure.service.DisplayMonitorWeb;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public IDisplayMonitor getDisplayMonitor(){
        return new DisplayMonitorWeb();
    }
}
