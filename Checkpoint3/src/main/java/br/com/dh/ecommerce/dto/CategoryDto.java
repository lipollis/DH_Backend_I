package br.com.dh.ecommerce.dto;

import br.com.dh.ecommerce.persistence.entities.CategoryEntity;
import lombok.Getter;
import lombok.Setter;
//model similar ao dto, o q faz a comunicação
@Getter //ASSINATURA LOMBOK
@Setter //ASSINATURA LOMBOK
public class CategoryDto {

    // ATRIBUTOS
    private Integer id;
    private String name;

    // CONSTRUTOR VAZIO
    public CategoryDto(){}

    // CONSTRUTOR PARA A CONVERSÃO ENTITY EM DTO
    public CategoryDto(CategoryEntity category){
        this.id = category.getId();
        this.name = category.getName();
    }

    // toString
    @Override
    public String toString() {
        return "CategoryDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
