package br.com.fiap.techchallange.infrastructure.service;

import br.com.fiap.techchallange.adapters.gateways.service.IPaymentQRCodeGateway;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.entity.enums.StatusPayment;


import java.io.IOException;

public class PaymentQRCodeGateway implements IPaymentQRCodeGateway {
    @Override
    public String initializePayment(String orderId, float value) throws IOException {
        return "";
    }

}
