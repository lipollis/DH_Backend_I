package br.com.dh.ecommerce.persistence.repository;

import br.com.dh.ecommerce.persistence.entities.CategoryEntity;
import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    Optional<List<CategoryEntity>> searchByProduct(String type);
}
