package br.com.dh.ecommerce.dto;

import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    // ATRIBUTOS
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    private CategoryDto category;

    // CONSTRUTOR VAZIO
    public ProductDto(){}

    // CONSTRUTOR PARA A CONVERSÃO ENTITY EM DTO
    public ProductDto(ProductEntity product){
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUrl = product.getImageUrl();
        this.category = new CategoryDto(product.getCategory());
    }

    // toString
    @Override
    public String toString() {
        return "ProductDto{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", price=" + price +
               ", description='" + description + '\'' +
               ", imageUrl='" + imageUrl + '\'' +
               ", category=" + category +
               '}';
    }
}
