package br.com.fiap.techchallange.infrastructure.config.usecase.orderpreparation;

import br.com.fiap.techchallange.core.usecase.tracking.EventTrigger;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IEventListenerOrder;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IEventTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventListenerConfig {

    @Bean
    public IEventTrigger getEventTrigger(IEventListenerOrder listenerOrder){
        return new EventTrigger(listenerOrder);
    }
}
