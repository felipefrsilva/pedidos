package br.com.fiap.techchallange.infrastructure.adapters.in;

import br.com.fiap.techchallange.orders.domain.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;


public record ProductDeserializer(String sku, String name, String description, float monetaryValue, String category) {
    public ProductDeserializer(
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

    public ProductDeserializer(@NotNull Product product) {
        this(product.getSku(), product.getName(), product.getDescription(), product.getMonetaryValue(), product.getCategory());
    }
}
