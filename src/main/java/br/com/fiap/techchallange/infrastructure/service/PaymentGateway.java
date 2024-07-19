package br.com.fiap.techchallange.infrastructure.service;

import br.com.fiap.techchallange.adapters.gateways.service.IPaymentGateway;
import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;


import java.io.IOException;

public class PaymentGateway implements IPaymentGateway {
    @Override
    public OutputDataPaymentDTO initializePayment(String orderId, float value) throws IOException {
        return null;
    }


}
