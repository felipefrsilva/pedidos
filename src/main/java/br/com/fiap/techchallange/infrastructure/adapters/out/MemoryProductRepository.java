package br.com.fiap.techchallange.infrastructure.adapters.out;

import br.com.fiap.techchallange.infrastructure.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.orders.domain.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class MemoryProductRepository implements IProductRepository {

    private final List<Product> products;

    public MemoryProductRepository(){
        products = new ArrayList<Product>();

//        products.add(new Product("123456A", "MC Lanche Feliz", "Hamburguer com queijo, salada especial e queijo", new MonetaryValue(new BigDecimal("35.00")), Category.Snack.getValue()));
//        products.add(new Product("123456B", "Quarteirão Com Queijo", "Hamburguer com queijo e salada", new MonetaryValue(new BigDecimal("28.00")), Category.Snack.getValue()));
//        products.add(new Product("123456C", "Coca-Cola 500ML", "Refrigerante Coca-Cola servido no copo de 500ML", new MonetaryValue(new BigDecimal("10.00")), Category.Drink.getValue()));
//        products.add(new Product("123456D", "Coca-Cola 300ML", "Refrigerante Coca-Cola servido no copo de 300ML", new MonetaryValue(new BigDecimal("10.00")), Category.Drink.getValue()));
//        products.add(new Product("123456E", "Torta de Maça", "Torta de Maça Caramelizada em uma casquinha crocante", new MonetaryValue(new BigDecimal("25.00")), Category.Dessert.getValue()));
//        products.add(new Product("123456F", "Sorvete de Casquinha", "Sorvete de Casquinha com creme de nata e chocolate", new MonetaryValue(new BigDecimal("8.00")), Category.Dessert.getValue()));
    }

    public MemoryProductRepository(List<Product> products) {
        this.products = products;
    }


    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProductBySku(String sku) {
        for (Product product : products) {
            if (product.getSku().equals(sku)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product createProduct(Product product){
        this.products.add(product);
        return product;
    }

    @Override
    public Product updateProduct(String sku, Product newProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getSku().equals(sku)) {
                products.set(i, newProduct);
                return newProduct;
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(String sku) {
        products.remove(this.getProductBySku(sku));
    }
}