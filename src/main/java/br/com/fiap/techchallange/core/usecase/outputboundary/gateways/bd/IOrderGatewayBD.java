package br.com.fiap.techchallange.core.usecase.outputboundary.gateways.bd;

import br.com.fiap.techchallange.core.entity.Order;

public interface IOrderGatewayBD {

    public void registerOrder(Order order);
}
