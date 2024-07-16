package br.com.fiap.techchallange.infrastructure.http;

import br.com.fiap.techchallange.infrastructure.dto.OrderDTO;

public interface IServiceOrder {

    String initializeService();
    OrderDTO getOrder(String idOrder);

    void removeProductToOrder(String idOrder, String sku);
}
