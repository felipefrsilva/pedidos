package br.com.fiap.techchallange.application.dto;

import br.com.fiap.techchallange.domain.vo.Item;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrackerOrderDTO implements Serializable {

    @Schema(name = "idOrder", example = "defa318d-d6e4-4184-8c15-9c50c446584f", required = true)
    private String orderId;
    @Schema(name = "numberOrder", example = "1", required = true)
    private Integer numberOrder;
    @Schema(name = "statusOrder", example = "Aberto", required = true)
    private String statusOrder;
    @Schema(name = "items", example = "[]", required = true)
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
