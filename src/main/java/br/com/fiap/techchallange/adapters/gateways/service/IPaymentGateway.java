package br.com.fiap.techchallange.adapters.gateways.service;

import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.entity.enums.StatusPayment;

import java.io.IOException;

public interface IPaymentGateway {

    void initializePayment(String orderId, float value) throws IOException;

    Payment getPayment(String orderId) throws IOException;

    StatusPayment getPaymentStatus(String orderId);

}
