package br.com.fiap.techchallange.core.entity;

import br.com.fiap.techchallange.core.entity.enums.StatusOrder;
import br.com.fiap.techchallange.core.entity.enums.StatusPayment;
import br.com.fiap.techchallange.core.entity.exceptions.ChangeNotAllowedOrderException;
import br.com.fiap.techchallange.core.entity.vo.Item;


import java.io.*;
import java.util.*;

public class Order implements Serializable {

    String id;
    Integer numberOrder;
    Map<String,Item> items;
    String status;
    float amount;
    Payment payment;
    Map<String, Integer> sequenceStatus;

    public Order(){
        this.id = UUID.randomUUID().toString();
        this.numberOrder = 0;
        this.items = new HashMap<String, Item>();
        this.payment = new Payment(this.id);
        this.status = StatusOrder.OPEN.getValue();
        this.amount  = 0;
        this.sequenceStatus = new HashMap<>();
        loadSequenceStatus();
    }

    public Order(String id,
                 HashMap<String, Item> items){
        this.id = id;
        this.setItems(items);
        this.payment = new Payment(this.id);
        this.status = StatusOrder.OPEN.getValue();
        this.calculateAmount();
        this.sequenceStatus = new HashMap<>();
        loadSequenceStatus();
    }

    public Order(String id,
                 Integer numberOrder,
                 HashMap<String, Item> items,
                 Payment payment,
                 String status){
        this.id = id;
        this.numberOrder = numberOrder;
        this.setItems(items);
        this.payment = payment;
        this.status = status;
        this.calculateAmount();
        this.sequenceStatus = new HashMap<>();
        loadSequenceStatus();
    }

    private void loadSequenceStatus(){
        sequenceStatus.put(StatusOrder.OPEN.getValue(), 1);
        sequenceStatus.put(StatusOrder.RECEIVED.getValue(), 2);
        sequenceStatus.put(StatusOrder.INPREPARATION.getValue(), 3);
        sequenceStatus.put(StatusOrder.READY.getValue(), 4);
        sequenceStatus.put(StatusOrder.FINISHED.getValue(), 5);
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
            throw new ChangeNotAllowedOrderException("Não é permitido adicionar produtos com o pagamento realizado.");
        }
    }

    public void removeProduct(String sku) {
        if (status.equals(StatusOrder.OPEN.getValue())) {
            items.remove(sku);
            this.calculateAmount();
        }else{
            throw new ChangeNotAllowedOrderException("Não é permitido remover produtos com o pagamento realizado.");
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
            throw new ChangeNotAllowedOrderException("Não é permitido adicionar o código de leitura com o pagamento realizado.");
        }
    }

    public void processingPayment(String code, StatusPayment statusPayment){
        if (status.equals(StatusOrder.OPEN.getValue())) {
            payment.addProcessingCode(code, statusPayment);
            this.status = StatusOrder.RECEIVED.getValue();
        }else{
            throw new ChangeNotAllowedOrderException("Não é permitido adicionar o código de processamento com o pagamento realizado.");
        }
    }

    public void updateStatus(StatusOrder statusOrder) {

        if(statusOrder.equals(StatusOrder.OPEN) || statusOrder.equals(StatusOrder.RECEIVED)){
            throw new ChangeNotAllowedOrderException("Alteração de status não permitido");
        }

        if(sequenceStatus.get(status) > sequenceStatus.get(statusOrder.getValue())){
            throw new ChangeNotAllowedOrderException("Sequencia do status do pedido violado");
        }

        this.status = statusOrder.getValue();
    }

    public void setNumberOrder(Integer numberOrder){
        if (status.equals(StatusOrder.RECEIVED.getValue()) && this.numberOrder == 0) {
            this.numberOrder = numberOrder;
        }
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

    public Integer getNumberOrder() {
        return this.numberOrder;
    }

    public Payment getPayment(){
        return copyPayment(this.payment);
    }

    public Map<String,Item> getItems(){
        Map<String,Item> copyItems = new HashMap<>();

        for (Map.Entry<String, Item> item : items.entrySet()) {
            copyItems.put(item.getKey(), copyItem(item.getValue()));
        }

        return copyItems;
    }

    public Item getItem(String sku){

        for (Map.Entry<String, Item> item : items.entrySet()) {
            if(item.getValue().getSKU().equals(sku)){
                return copyItem(item.getValue());
            }
        }

        return null;
    }

    private Payment copyPayment(Payment original) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(original);
            oos.flush();
            oos.close();
            bos.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Payment) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException("Not found class Item for orderId " + this.id + " " + e.getMessage());
        }
    }

    private Item copyItem(Item original) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(original);
            oos.flush();
            oos.close();
            bos.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Item) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException("Not found class payment for orderId "  + this.id);
        }
    }


}
