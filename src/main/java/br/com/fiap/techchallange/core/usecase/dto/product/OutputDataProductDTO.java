package br.com.fiap.techchallange.core.usecase.dto.product;

public class OutputDataProductDTO {

    private String sku;
    private String name;
    private String description;
    private float value;
    private String category;

    public OutputDataProductDTO(String sku, String name, String description, float value, String category) {
        this.setSku(sku);
        this.setName(name);
        this.setDescription(description);
        this.setValue(value);
        this.setCategory(category);
    }

    private void setSku(String sku) {
        this.sku = sku;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setValue(float value) {
        this.value = value;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    private void setCategory(String category) {
        this.category = category;
    }
}
