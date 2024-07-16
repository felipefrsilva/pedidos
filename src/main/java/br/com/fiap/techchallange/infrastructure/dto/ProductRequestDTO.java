package br.com.fiap.techchallange.infrastructure.dto;

import br.com.fiap.techchallange.core.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;


public record ProductRequestDTO(String sku, String name, String description, float monetaryValue, String category) {
    public ProductRequestDTO(
            @JsonProperty("sku") String sku,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("monetaryValue") float monetaryValue,
            @JsonProperty("category") String category
    ) {
        this.name = name;
        this.monetaryValue = monetaryValue;
        this.sku = sku;
        this.description = description;
        this.category = category;
    }

    public ProductRequestDTO(@NotNull Product product) {
        this(product.getSku(), product.getName(), product.getDescription(), product.getMonetaryValue(), product.getCategory());
    }
}
