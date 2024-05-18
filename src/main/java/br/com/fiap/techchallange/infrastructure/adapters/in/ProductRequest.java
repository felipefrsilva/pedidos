package br.com.fiap.techchallange.infrastructure.adapters.in;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ProductRequest(String sku, String name, String description, double monetaryValue, String category) {
    public ProductRequest(
            @JsonProperty("sku") String sku,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("monetaryValue") double monetaryValue,
            @JsonProperty("category") String category
    ) {
        this.name = name;
        this.monetaryValue = monetaryValue;
        this.sku = sku;
        this.description = description;
        this.category = category;
    }
}
