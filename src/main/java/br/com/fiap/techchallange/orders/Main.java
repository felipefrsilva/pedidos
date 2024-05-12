package br.com.fiap.techchallange.orders;

import br.com.fiap.techchallange.orders.domain.entity.Order;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import br.com.fiap.techchallange.orders.domain.factory.FactoryOrder;
import br.com.fiap.techchallange.orders.domain.vo.Category;
import br.com.fiap.techchallange.orders.domain.vo.Item;
import br.com.fiap.techchallange.orders.domain.vo.MonetaryValue;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Order order = FactoryOrder.getOrder();
        MonetaryValue value = new MonetaryValue(new BigDecimal(35.00));
        Product product = new Product("123456","MC Lanche Feliz", "Hamburguer com queijo, salada especial e queijo", value, Category.Snack.getValue());

        Item item = new Item(product, 3);
        order.addItem(item);
        System.out.printf("Valor do Pedido: R$ %.2f%n", order.getValorTotal());
    }
}
