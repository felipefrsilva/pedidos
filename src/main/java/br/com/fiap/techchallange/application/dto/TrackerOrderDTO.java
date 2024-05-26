package br.com.fiap.techchallange.application.dto;

import br.com.fiap.techchallange.domain.vo.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrackerOrderDTO implements Serializable {

    private String orderId;
    private Integer numberOrder;
    private String statusOrder;
    private Map<String,Item> items;

    public TrackerOrderDTO(String orderId, Integer numberOrder, Map<String,Item> items, String status) {
        this.orderId = orderId;
        this.numberOrder = numberOrder;
        this.items = items;
        this.statusOrder = status;
    }

    public TrackerOrderDTO(String orderId){
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Integer getNumberOrder() {
        return numberOrder;
    }

    public List<Item> getItems() {
        List<Item> list = new ArrayList<>();
        for (Map.Entry<String, Item> item : items.entrySet()) {
            list.add(item.getValue());
        }
        return list;
    }

    public String getStatusOrder() {
        return statusOrder;
    }
}
