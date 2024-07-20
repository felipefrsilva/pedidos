package br.com.fiap.techchallange.infrastructure.config.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.usecase.orderpayment.*;
import br.com.fiap.techchallange.infrastructure.service.PaymentQRCodeGatewayMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPaymentUseCaseConfig {

    @Bean
    PaymentInitializeUseCase getPaymentInitializeUseCase(IOrderRepository repositoryOrder) {
        return new PaymentInitializeUseCase(repositoryOrder, new PaymentQRCodeGatewayMock());
    }

    @Bean
    PaymentProcessingUseCase getPaymentProcessingUseCase(IOrderRepository repositoryOrder) {
        return new PaymentProcessingUseCase(repositoryOrder);
    }

    @Bean
    PaymentCheckStatusUseCase getPaymentCheckStatusUseCase(IOrderRepository orderRepository) {
        return new PaymentCheckStatusUseCase(orderRepository);
    }

    @Bean
    PaymentGetReadingCodeUseCase getPaymentGetReadingCodeUseCase(IOrderRepository orderRepository) {
        return new PaymentGetReadingCodeUseCase(orderRepository);
    }

    @Bean
    GetOrderPaymentUseCase getOrderPaymentUseCase(IOrderRepository orderRepository) {
        return new GetOrderPaymentUseCase(orderRepository);
    }
}
