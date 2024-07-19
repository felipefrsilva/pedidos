package br.com.fiap.techchallange.infrastructure.config.controller.orderpayment;

import br.com.fiap.techchallange.adapters.controllers.orderpayment.*;
import br.com.fiap.techchallange.core.usecase.orderpayment.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPaymentControllerConfig {
    @Bean
    PaymentCheckStatusController getPaymentCheckStatusController(PaymentCheckStatusUseCase paymentCheckStatusUseCase) {
        return new PaymentCheckStatusController(paymentCheckStatusUseCase);
    }

    @Bean
    PaymentGetReadingCodeController getReadingCodeController(PaymentGetReadingCodeUseCase paymentGetReadingCodeUseCase) {
        return new PaymentGetReadingCodeController(paymentGetReadingCodeUseCase);
    }

    @Bean
    PaymentInitializeController getPaymentInitializeController(PaymentInitializeUseCase paymentInitializeUseCase) {
        return new PaymentInitializeController(paymentInitializeUseCase);
    }

    @Bean
    PaymentUpdateOrderController getPaymentUpdateOrderController(PaymentUpdateOrderUseCase paymentUpdateOrderUseCase) {
        return new PaymentUpdateOrderController(paymentUpdateOrderUseCase);
    }

    @Bean
    GetOrderPaymentController getOrderPaymentController(GetOrderPaymentUseCase getOrderPaymentUseCase) {
        return new GetOrderPaymentController(getOrderPaymentUseCase);
    }
}
