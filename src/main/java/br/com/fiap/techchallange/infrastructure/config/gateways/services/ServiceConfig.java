package br.com.fiap.techchallange.infrastructure.config.gateways.services;

import br.com.fiap.techchallange.adapters.controllers.tracking.IGetLatestOrderNumberController;
import br.com.fiap.techchallange.adapters.gateways.service.IDisplayMonitor;
import br.com.fiap.techchallange.adapters.gateways.service.IGenerateNumberOrder;
import br.com.fiap.techchallange.infrastructure.service.DisplayMonitorConsole;
import br.com.fiap.techchallange.infrastructure.service.DisplayMonitorWeb;
import br.com.fiap.techchallange.infrastructure.service.GenerateNumberOrder;
import br.com.fiap.techchallange.infrastructure.service.mock.GenerateNumberOrderMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public IDisplayMonitor getDisplayMonitor(){
        return new DisplayMonitorConsole();
    }

    @Bean
    public IGenerateNumberOrder getGenerateNumberOrder(IGetLatestOrderNumberController getLatestOrderNumberController){
        return new GenerateNumberOrder(getLatestOrderNumberController);
    }
}
