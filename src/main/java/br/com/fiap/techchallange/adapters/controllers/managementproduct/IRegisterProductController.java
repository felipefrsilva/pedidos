package br.com.fiap.techchallange.adapters.controllers.managementproduct;

public interface IRegisterProductController {
    void invoke(String sku, String name, String description, float monetaryValue, String category);
}
