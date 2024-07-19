package br.com.fiap.techchallange.infrastructure.config.controller.orderpayment;

import br.com.fiap.techchallange.adapters.controllers.orderpayment.IOrderPaymentController;
import br.com.fiap.techchallange.adapters.controllers.orderpayment.OrderPaymentController;
import br.com.fiap.techchallange.core.usecase.orderpayment.OrderPaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPaymentControllerConfig {

    @Bean
    public IOrderPaymentController getOrderPaymentController(OrderPaymentUseCase orderPaymentUseCase){
        return new OrderPaymentController(orderPaymentUseCase);
    }
}
