package br.com.fiap.techchallange.infrastructure.config.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.usecase.orderpayment.OrderPaymentUseCase;
import br.com.fiap.techchallange.infrastructure.service.PaymentGatewayMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPaymentUseCaseConfig {
    @Bean
    OrderPaymentUseCase getOrderPaymentUseCase(IOrderRepository repositoryOrder) {
        return new OrderPaymentUseCase(repositoryOrder, new PaymentGatewayMock()); // TODO: wire gateway payment
    }
}
