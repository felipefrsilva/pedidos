package br.com.fiap.techchallange.adapters.gateways.service;

import br.com.fiap.techchallange.core.entity.Payment;

import java.io.IOException;

public interface IPaymentGateway {

    public Payment initializePayment(String orderId, float value) throws IOException;

}
