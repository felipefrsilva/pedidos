package br.com.fiap.techchallange.domain.factory;

import br.com.fiap.techchallange.domain.entity.Payment;
import br.com.fiap.techchallange.domain.service.ServicePayment;


public class FactoryPayment {

    public static Payment createPayment(String idOrder){
        ServicePayment service = new ServicePayment();
        Payment payment = new Payment(idOrder);

        service.addPayment(payment);
        return payment;
    }
}
