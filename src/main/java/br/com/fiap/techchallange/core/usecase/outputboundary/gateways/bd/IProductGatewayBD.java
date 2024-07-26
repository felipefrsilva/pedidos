package br.com.fiap.techchallange.core.usecase.outputboundary.gateways.bd;

import br.com.fiap.techchallange.core.entity.Product;


import java.util.List;

public interface IProductGatewayBD {
    public List<Product> getProducts();
}
