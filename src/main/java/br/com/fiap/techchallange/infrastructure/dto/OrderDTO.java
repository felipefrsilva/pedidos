package br.com.fiap.techchallange.infrastructure.dto;

import java.io.Serializable;
import java.util.List;

public class OrderDTO implements Serializable {

    private String id;
    private Integer numberOrder;
    private List<ItemDTO> items;
    private String status;
    private float amount = 0.0f;
    private String readingCode;
    private String processingCode;

    public OrderDTO(){

    }

    public OrderDTO(String idOrder, List<ItemDTO> itemsDTO, String status, float amount) {
        this.setId(idOrder);
        this.setItems(itemsDTO);
        this.status = status;
        this.setAmount(amount);
    }

    public OrderDTO(String idOrder, Integer numberOrder, List<ItemDTO> itemsDTO, String status, float amount, String readingCode, String processingCode) {
        this.setId(idOrder);
        this.setNumberOrder(numberOrder);
        this.setItems(itemsDTO);
        this.status = status;
        this.setAmount(amount);
        this.setReadingCode(readingCode);
        this.setProcessingCode(processingCode);
    }

    public String getId() {
        return id;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public float getAmount() {
        return amount;
    }

    private void setAmount(float amount) {
        this.amount = amount;
    }

    public String getReadingCode() {
        return readingCode;
    }

    public String getProcessingCode() {
        return processingCode;
    }

    private void setReadingCode(String readingCode) {
        this.readingCode = readingCode;
    }

    private void setProcessingCode(String processingCode) {
        this.processingCode = processingCode;
    }

    public Integer getNumberOrder() {
        return numberOrder;
    }

    private void setNumberOrder(Integer numberOrder) {
        this.numberOrder = numberOrder;
    }
}
