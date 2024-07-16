package br.com.fiap.techchallange.infrastructure.factory;
import br.com.fiap.techchallange.core.entity.Payment;

public class FactoryPayment {

    public static Payment createPayment(String idOrder){
        return new Payment(idOrder);
    }
}
