package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.infrastructure.factory.FactoryProductRepository;
import br.com.fiap.techchallange.infrastructure.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.orders.domain.entity.Order;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import br.com.fiap.techchallange.orders.domain.factory.FactoryOrder;
import br.com.fiap.techchallange.orders.domain.vo.Item;
;

public class Main {

    public static void main(String[] args) {

        IProductRepository repository = FactoryProductRepository.create();
        Product product = repository.getProductBySku(args[0]);

        if (product == null) {
            System.out.println("Produto não encontrado!");
        }
        else {
            Order order = FactoryOrder.CreateOrder();
            Item item = new Item(product, 0);

            order.addItem(item);
            System.out.printf("Item %s adicionado no Pedido. Valor do Pedido: R$ %.2f%n", product.getName(), order.getAmount());
            order.removeItem(item);
            System.out.printf("Item %s removido do Pedido. Valor do Pedido: R$ %.2f%n", product.getName(), order.getAmount());
        }
    }
}
