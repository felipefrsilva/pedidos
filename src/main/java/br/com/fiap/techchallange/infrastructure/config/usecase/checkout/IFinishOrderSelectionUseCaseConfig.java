package br.com.fiap.techchallange.infrastructure.config.usecase.checkout;


import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.usecase.inputboundary.checkout.IFinishOrderSelectionUseCase;
import br.com.fiap.techchallange.core.usecase.checkout.FinishOrderSelectionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IFinishOrderSelectionUseCaseConfig {

    @Bean
    public IFinishOrderSelectionUseCase getinstanceFinishOrderUseCase(IOrderRepository orderRepository){
        return new FinishOrderSelectionUseCase(orderRepository);
    }
}
