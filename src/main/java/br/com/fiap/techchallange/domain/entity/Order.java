package br.com.fiap.techchallange.domain.entity;

import br.com.fiap.techchallange.domain.enums.StatusOrder;
import br.com.fiap.techchallange.domain.factory.FactoryPayment;
import br.com.fiap.techchallange.domain.vo.Item;


import java.util.*;

public class Order {

    String id;
    Integer numberOrder;
    Map<String,Item> items;
    String status;
    float amount;
    Payment payment;

    public Order(){
        this.id = UUID.randomUUID().toString();
        this.items = new HashMap<String, Item>();
        this.payment = FactoryPayment.createPayment(this.id);
        this.status = StatusOrder.OPEN.getValue();
        this.amount  = 0;
    }

    public Order(String id,
                 HashMap<String,
                 Item> items,
                 Payment payment,
                 String status,
                 float amount){
        this.id = id;
        this.setItems(items);
        this.payment = payment;
        this.status = status;
        this.amount = amount;
    }

    public void addProduct(Product product, Integer qtd){
        if (status.equals(StatusOrder.OPEN.getValue())) {
            int valueOld = 0;

            if( items.get(product.getSku()) != null){
                valueOld = items.get(product.getSku()).getQuantity();
                this.items.remove(product.getSku());
            }

           Integer qtdAmount = valueOld + qtd;
            this.items.put(product.getSku(), new Item(product, qtdAmount));
            this.calculateAmount();

        }else{
            handlerError("Add Item");
        }
    }

    public void removeProduct(String sku) {
        if (status.equals(StatusOrder.OPEN.getValue())) {
            items.remove(sku);
            this.calculateAmount();
        }else{
            handlerError("Remove Item");
        }
    }

    private void calculateAmount(){
        this.amount = 0;
        for (Map.Entry<String, Item> item :items.entrySet()) {
            this.amount += item.getValue().getAmount();
        }
    }

    public void addReadingCodePayment(String code){
        if (status.equals(StatusOrder.OPEN.getValue())) {
            payment.addReadingCode(code);
        }else{
            handlerError("Payment");
        }
    }

    public void processingPayment(String code){
        if (status.equals(StatusOrder.OPEN.getValue())) {
            payment.addProcessingCode(code);
            this.status = StatusOrder.RECEIVED.getValue();
        }else{
            handlerError("Payment");
        }
    }

    private void handlerError(String operation){
        throw new IllegalStateException(
                operation + " cannot be processing, order status different of OPEN."
        );
    }

    public String getId() {
        return id;
    }

    public float getAmount() {
        return this.amount;
    }

    public Map<String, Float> getValueProducts(){
        Map<String, Float> valueProducts = new HashMap<>();

        for (Map.Entry<String, Item> item :items.entrySet()) {
            valueProducts.put(item.getValue().getSKU(), item.getValue().getAmount());
        }
        return valueProducts;
    }

    public Integer getQtdProduct(String sku){
        return items.get(sku).getQuantity();
    }

    public String getCodeReadingPayment() {
        return payment.getReadingCode();
    }

    public String getCodeProcessingPayment() {
        return payment.getProcessingCode();
    }

    public String getStatus() {
        return status;
    }

    private void setItems(Map<String,Item> items){
        this.items = items;
        this.calculateAmount();
    }
}