package br.com.fiap.techchallange.infrastructure.adapters.in;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ProductRequest(String name, double monetaryValue, String sku, String description, String category) {
    public ProductRequest(@JsonProperty("name") String name,
                          @JsonProperty("monetaryValue") double monetaryValue,
                          @JsonProperty("sku") String sku,
                          @JsonProperty("description") String description,
                          @JsonProperty("category") String category) {
        this.name = name;
        this.monetaryValue = monetaryValue;
        this.sku = sku;
        this.description = description;
        this.category = category;
    }
}
