package br.com.fiap.techchallange.core.usecase.dto.ordercreation;

import br.com.fiap.techchallange.core.entity.vo.Item;

import java.util.HashMap;
import java.util.Map;

public class InputDataOrderDTO {

    private String id;
    private HashMap<String, Item> items;
    private String description;
    private String status;
    private float amount;

    public InputDataOrderDTO(String id) {
        this.setId(id);
    }

    public InputDataOrderDTO(String id, String description, HashMap<String, Item> items, String status, float amount) {
        this.setId(id);
        this.setDescription(description);
        this.setStatus(status);
        this.setAmount(amount);
        this.setItems(items);
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    private void setAmount(float amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
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
