package br.com.dh.ecommerce.persistence.entities;

import br.com.dh.ecommerce.dto.CategoryDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter //ASSINATURA LOMBOK
@Setter //ASSINATURA LOMBOK
@Entity // IDENTIFICA QUE É UMA ENTIDADE
@Table(name = "categories") // IDENTIFICA QUE É UMA TABELA

public class CategoryEntity {

    @Id // INDICAÇÃO DO ID DA TABELA
    @SequenceGenerator(name = "sequenceCategory", sequenceName = "sequenceCategory", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCategory")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)//1:N?
    private Set<ProductEntity> products = new HashSet<>();

    // CONSTRUTOR VAZIO
    public CategoryEntity(){}

    // CONSTRUTOR PARA A CONVERSÃO ENTITY EM DTO
    public CategoryEntity(CategoryDto category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    // toString
    @Override
    public String toString() {
        return "CategoryEntity{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", products=" + products +
               '}';
    }
}
