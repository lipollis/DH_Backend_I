package br.com.dh.ecommerce.persistence.repository.impl;

import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import br.com.dh.ecommerce.persistence.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// ABSTRACT PQ QDO IMPLEMENTAR O REPOSITORY NÃO TRAZER TUDO DO JPA. CONTINUAÇÃO DO REPOSITORY MAS COM NOVAS QUERY
public abstract class ProductRepositoryImpl implements ProductRepository {

    // AQUI O HIPERBANATE PRODUZ A QUERY PARA O BANCO
    @Query("SELECT p FROM products p WHERE p.category_id = ?1")
    public abstract Optional<List<ProductEntity>> searchByCategory(String type);
}
