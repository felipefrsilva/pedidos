package br.com.fiap.techchallange.orders.domain.factory;

import br.com.fiap.techchallange.orders.domain.entity.Order;

public class FactoryOrder {

    public static Order CreateOrder(){
        return new Order();
    }
}
