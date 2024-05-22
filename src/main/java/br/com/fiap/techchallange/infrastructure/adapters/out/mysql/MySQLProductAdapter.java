package br.com.fiap.techchallange.infrastructure.adapters.out.mysql;


import br.com.fiap.techchallange.application.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class MySQLProductAdapter implements IProductRepository {

    @Autowired
    private MySQLProductCrudRepository crudRepository;

//    @Autowired
//    public MySQLProductAdapter(MySQLProductCrudRepository crudRepository) {
//        this.crudRepository = crudRepository;
//    }

    @Override
    public List<Product> getProducts() {
        Iterable<MySQLProductEntity> mySQLProductEntityList = this.crudRepository.findAll();
        List<Product> productList = new java.util.ArrayList<>(List.of());
        mySQLProductEntityList.forEach((prd) -> productList.add(prd.toDomainEntity()));
        return productList;
    }

    @Override
    public Product getProductBySku(String sku) {
        MySQLProductEntity mySQLProductEntity = this.crudRepository.findBySku(sku);
        return mySQLProductEntity.toDomainEntity();
    }

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public void updateProduct(String sku, Product product) {

    }

    @Override
    public void deleteProduct(String sku) {
        MySQLProductEntity mySQLProductEntity = this.crudRepository.findBySku(sku);
        this.crudRepository.delete(mySQLProductEntity);
    }
}
