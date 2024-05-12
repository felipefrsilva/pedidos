package br.com.fiap.techchallange.orders.domain.factory;

import br.com.fiap.techchallange.orders.domain.entity.Payment;

public class FactoryPayment {

    public static Payment getPayment(){
        return new Payment();
    }
}
