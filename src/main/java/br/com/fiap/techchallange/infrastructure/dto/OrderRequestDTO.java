package br.com.fiap.techchallange.infrastructure.dto;

import br.com.fiap.techchallange.core.entity.vo.Item;

import java.util.HashMap;

public class OrderRequestDTO {
    private String id;
    private HashMap<String, Item> items;

    public OrderRequestDTO(String id, HashMap<String, Item> items) {
        this.setId(id);
        this.setItems(items);
    }

    public String getId() {
        return id;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setItems(HashMap<String, Item> items) {
        this.items = items;
    }
}
