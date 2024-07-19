package br.com.fiap.techchallange.infrastructure.config.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.usecase.orderpayment.*;
import br.com.fiap.techchallange.infrastructure.service.PaymentGatewayMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPaymentUseCaseConfig {

    @Bean
    PaymentInitializeUseCase getPaymentInitializeUseCase(IOrderRepository repositoryOrder) {
        return new PaymentInitializeUseCase(repositoryOrder, new PaymentGatewayMock());
    }

    @Bean
    PaymentUpdateOrderUseCase getPaymentUpdateOrderUseCase(IOrderRepository repositoryOrder) {
        return new PaymentUpdateOrderUseCase(repositoryOrder, new PaymentGatewayMock());
    }

    @Bean
    PaymentCheckStatusUseCase getPaymentCheckStatusUseCase() {
        return new PaymentCheckStatusUseCase(new PaymentGatewayMock());
    }

    @Bean
    PaymentGetReadingCodeUseCase getPaymentGetReadingCodeUseCase() {
        return new PaymentGetReadingCodeUseCase(new PaymentGatewayMock());
    }

    @Bean
    GetOrderPaymentUseCase getOrderPaymentUseCase() {
        return new GetOrderPaymentUseCase(new PaymentGatewayMock());
    }
}
