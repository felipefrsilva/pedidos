package br.com.fiap.techchallange.infrastructure.adapters.out.mysql;

import br.com.fiap.techchallange.domain.entity.Product;
import br.com.fiap.techchallange.domain.vo.MonetaryValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.math.BigDecimal;


@Entity(name="product")
public class MySQLProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private float monetaryValue;

    private String sku;

    private String description;

    private String category;

    public Product toDomainEntity() {
        return new Product(this.sku, this.name, this.description, new MonetaryValue(BigDecimal.valueOf(this.monetaryValue)).getValue(), this.category);
    }
}
