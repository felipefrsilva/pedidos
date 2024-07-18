package br.com.fiap.techchallange.core.usecase.dto.order;

public class OutputDataOrderDTO {

    private String id;
    private int number_order;
    private String description;
    private String status;
    private float amount;

    public OutputDataOrderDTO(String id, int number_order, String description, String status, float amount) {
        this.setId(id);
        this.setNumber_order(number_order);
        this.setDescription(description);
        this.setStatus(status);
        this.setAmount(amount);
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setNumber_order(int number_order) {
        this.number_order = number_order;
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

    public int getNumber_order() {
        return number_order;
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
}
