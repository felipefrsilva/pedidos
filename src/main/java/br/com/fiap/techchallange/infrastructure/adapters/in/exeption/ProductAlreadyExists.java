package br.com.fiap.techchallange.infrastructure.adapters.in.exeption;
// TODO: Validate if this is correct
public class ProductAlreadyExists extends Exception{

    public ProductAlreadyExists() {}

    public ProductAlreadyExists(String sku) {
        super("SKU " + sku + " already exists");
    }

}
