package br.com.fiap.techchallange.infrastructure.config.usecase.tracking;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IOrderListingUseCase;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.tracking.IDisplayInformationOrderPresenter;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IEventListenerOrder;
import br.com.fiap.techchallange.core.usecase.tracking.OrderListingUseCase;
import br.com.fiap.techchallange.core.usecase.tracking.OrderUpdateStatusUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrackingUseCaseConfig {

    @Bean
    public IEventListenerOrder getListenerOrder(IOrderRepository orderRepository,
                                                IDisplayInformationOrderPresenter displayInformationOrderPresenter){
        return new OrderUpdateStatusUseCase(orderRepository, displayInformationOrderPresenter);
    }

    @Bean
    public IOrderListingUseCase getOrderListingUseCase(IOrderRepository orderRepository){
        return new OrderListingUseCase(orderRepository);
    }
}
