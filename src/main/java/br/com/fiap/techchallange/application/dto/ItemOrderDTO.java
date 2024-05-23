package br.com.fiap.techchallange.application.dto;

public class ItemOrderDTO {

    private String idOrder;
    private ItemDTO item;

    public ItemOrderDTO() {}

    public ItemOrderDTO(String idOrder, ItemDTO item) {
        this.setIdOrder(idOrder);
        this.setItem(item);
    }

    public String getIdOrder() {
        return idOrder;
    }

    public ItemDTO getItem() {
        return item;
    }

    private void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    private void setItem(ItemDTO item) {
        this.item = item;
    }
}
