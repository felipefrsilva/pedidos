package br.com.fiap.techchallange.infrastructure.adapters.out.mysql;


import br.com.fiap.techchallange.infrastructure.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
//@Controller("mysql")
public class MySQLProductAdapter implements IProductRepository {

    private final MySQLProductCrudRepository crudRepository;

    @Autowired
    public MySQLProductAdapter(MySQLProductCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public List<Product> getProducts() {
        Iterable<MySQLProductEntity> mySQLProductEntityList = this.crudRepository.findAll();
        List<Product> productList = new java.util.ArrayList<>(List.of());
        mySQLProductEntityList.forEach((prd) -> productList.add(prd.toDomainEntity()));
        return productList;
    }

    @Override
    public Product getProductBySku(@PathVariable String sku) {
        MySQLProductEntity mySQLProductEntity = this.crudRepository.findBySku(sku);
        return mySQLProductEntity.toDomainEntity();
    }

    @Override
    public Product createProduct(Product product) {
        MySQLProductEntity mySQLProductEntity = new MySQLProductEntity();
        mySQLProductEntity.setSku(product.getSku());
        mySQLProductEntity.setName(product.getName());
        mySQLProductEntity.setDescription(product.getDescription());
        mySQLProductEntity.setMonetaryValue(product.getMonetaryValue());
        mySQLProductEntity.setCategory(product.getCategory());
        this.crudRepository.save(mySQLProductEntity);
        return product;
    }

    @Override
    public Product updateProduct(String sku, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(String sku) {
        MySQLProductEntity mySQLProductEntity = this.crudRepository.findBySku(sku);
        this.crudRepository.delete(mySQLProductEntity);
    }
}
