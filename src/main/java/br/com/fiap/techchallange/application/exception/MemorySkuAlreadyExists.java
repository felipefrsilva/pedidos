package br.com.fiap.techchallange.application.exception;
// TODO: Validate if this is correct
public class MemorySkuAlreadyExists extends Exception{

    public MemorySkuAlreadyExists() {}

    public MemorySkuAlreadyExists(String sku) {
        super("SKU " + sku + " already exists");
    }

}
