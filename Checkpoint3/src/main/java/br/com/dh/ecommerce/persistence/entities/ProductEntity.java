package br.com.dh.ecommerce.persistence.entities;

import br.com.dh.ecommerce.dto.ProductDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter //ASSINATURA LOMBOK
@Setter //ASSINATURA LOMBOK
@Entity // IDENTIFICA QUE É UMA ENTIDADE
@Table(name = "products") // IDENTIFICA QUE É UMA TABELA
public class ProductEntity {

    @Id
    @SequenceGenerator(name = "sequenceProduct", sequenceName = "sequenceProduct", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceProduct")
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "title", length = 50, nullable = false)
    private String title;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "description", length = 255, nullable = false)
    private String description;
    
    @Column(name = "image", length = 255, nullable = false)
    private String imageUrl;

    // RELACIONAMENTO N:1 (?1:N)
    // CASCADE - QUANDO DELETAR O PRODUCT TAMBÉM DELETARÁ A CATEGORY OU QUALQUER OUTRA CLASSE QUE SE RELACIONAR COM PRODUCT
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    // CONSTRUTOR VAZIO - PARA QUANDO SOBREESCREVER
    public ProductEntity(){}

    // CONSTRUTOR PARA A CONVERSÃO DTO EM ENTITY
    public ProductEntity(ProductDto product){
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUrl = product.getImageUrl();
        this.category = new CategoryEntity(product.getCategory());
    }

    // toString
    @Override
    public String toString() {
        return "ProductEntity{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", price=" + price +
               ", description='" + description + '\'' +
               ", imageUrl='" + imageUrl + '\'' +
               ", category=" + category +
               '}';
    }
}
