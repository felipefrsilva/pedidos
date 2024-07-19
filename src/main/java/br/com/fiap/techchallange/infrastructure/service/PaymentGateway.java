package br.com.fiap.techchallange.infrastructure.service;

import br.com.fiap.techchallange.adapters.gateways.service.IPaymentGateway;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.entity.enums.StatusPayment;
import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;


import java.io.IOException;

public class PaymentGateway implements IPaymentGateway {
    @Override
    public void initializePayment(String orderId, float value) throws IOException {
    }

    @Override
    public Payment getPayment(String orderId) {
        return null;
    }

    @Override
    public StatusPayment getPaymentStatus(String orderId) {
        return null;
    }


}
