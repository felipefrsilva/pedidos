package br.com.fiap.techchallange.core.usecase.dto.order;

import br.com.fiap.techchallange.core.entity.vo.Item;

import java.util.HashMap;

public class InputDataOrderDTO {

    private String id;
    private HashMap<String, Item> items;
    private float amount;

    public InputDataOrderDTO(String id, HashMap<String, Item> items, float amount) {
        this.setId(id);
        this.setAmount(amount);
        this.setItems(items);
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setAmount(float amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    private void setItems(HashMap<String, Item> items) {
        this.items = items;
    }
}
