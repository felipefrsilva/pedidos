package br.com.fiap.techchallange.orders.domain.entity;

import br.com.fiap.techchallange.orders.domain.factory.FactoryPayment;
import br.com.fiap.techchallange.orders.domain.vo.Item;
import br.com.fiap.techchallange.orders.domain.vo.StatusOrder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order {

    List<Item> items;
    StatusOrder status;
    float valorTotal;
    Payment payment;

    public Order(){
        this.items = new ArrayList<Item>();
        this.payment = FactoryPayment.getPayment();
        this.status = StatusOrder.OPEN;
        this.valorTotal  = 0;
    }

    public void addItem(Item item){
        this.items.add(item);
        this.valorTotal += item.getAmount();
    }

    public void removeItem(Item item) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            if (currentItem.equals(item)) {
                iterator.remove();
                this.valorTotal -= item.getAmount();
                break;
            }
        }
    }

    public float getValorTotal() {
        return valorTotal;
    }

}
