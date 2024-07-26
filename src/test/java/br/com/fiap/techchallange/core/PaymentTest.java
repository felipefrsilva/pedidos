package br.com.fiap.techchallange.core;

import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.entity.enums.MethodPayment;
import org.junit.jupiter.api.Test;

import java.util.Objects;


public class PaymentTest {

    @Test
    void createPayment(){
        String idOrder = "123456F";
        Payment payment = new Payment(idOrder);

        assert Objects.equals(payment.getMethod(), MethodPayment.QRCODE.getValue());

    }

}
