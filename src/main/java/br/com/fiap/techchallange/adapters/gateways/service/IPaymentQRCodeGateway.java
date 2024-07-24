package br.com.fiap.techchallange.adapters.gateways.service;

import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.entity.enums.StatusPayment;

import java.io.IOException;

public interface IPaymentQRCodeGateway {

    String initializePayment(String orderId, float value) throws IOException;


}
