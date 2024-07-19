package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.service.IPaymentGateway;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IGetOrderPaymentUseCase;

import java.io.IOException;

public class GetOrderPaymentUseCase implements IGetOrderPaymentUseCase {
    IPaymentGateway gatewayPayment;

    public GetOrderPaymentUseCase(IPaymentGateway gatewayPayment) {
        this.gatewayPayment = gatewayPayment;
    }

    @Override
    public OutputDataPaymentDTO getOrderPayment(String idOrder) throws IOException {
        Payment payment = gatewayPayment.getPayment(idOrder);
        OutputDataPaymentDTO outputDataPaymentDTO = new OutputDataPaymentDTO(payment);
        return outputDataPaymentDTO;
    }
}
