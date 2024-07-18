package br.com.fiap.techchallange.infrastructure.config.usecase.tracking;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.usecase.tracking.IEventListenerOrder;
import br.com.fiap.techchallange.core.usecase.tracking.OrderUpdateStatusUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrackingConfig {

    @Bean
    public IEventListenerOrder getListenerOrder(IOrderRepository orderRepository){
        return new OrderUpdateStatusUseCase(orderRepository);
    }
}
