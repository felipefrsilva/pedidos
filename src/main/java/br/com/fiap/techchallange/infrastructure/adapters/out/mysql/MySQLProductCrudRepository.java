package br.com.fiap.techchallange.infrastructure.adapters.out.mysql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySQLProductCrudRepository extends CrudRepository<MySQLProductEntity, Integer> {

    @Query("from product a where a.sku=:sku")
    public MySQLProductEntity findBySku(String sku);
}
