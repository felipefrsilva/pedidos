package br.com.fiap.techchallange.adapters.controllers.managementproduct;

public interface IUpdateProductController {
    void invoke(String sku, String name, String description, float v, String category);
}
