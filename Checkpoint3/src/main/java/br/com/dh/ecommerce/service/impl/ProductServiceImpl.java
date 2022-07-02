package br.com.dh.ecommerce.service.impl;

import br.com.dh.ecommerce.dto.ProductDto;
import br.com.dh.ecommerce.persistence.entities.CategoryEntity;
import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import br.com.dh.ecommerce.persistence.repository.CategoryRepository;
import br.com.dh.ecommerce.persistence.repository.ProductRepository;
import br.com.dh.ecommerce.service.IeCommerceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // INSTANCIAR INTERFACE
public class ProductServiceImpl
        // implements IeCommerceService<ProductDto>
{
    @Autowired
    private ProductRepository productRepository;

    public Optional<List<ProductEntity>> listCategory(String category){

        return productRepository.searchByCategory(category);
    }

    public ProductDto createProduct(ProductDto productDto){
        ProductEntity product = new ProductEntity(productDto);
        return new ProductDto(productRepository.save(product));
    }

    public ProductDto searchById(Integer id){
        ProductDto productDto = new ProductDto(productRepository.getById(id));
        return productDto;
    }

    public List<ProductDto> listAll(){
        List<ProductEntity> productEntityList = new ArrayList<>();
        productEntityList.addAll(productRepository.findAll());
        List<ProductDto> productDtoList = new ArrayList<>();
        productEntityList.forEach(productEntity -> {
            ProductDto productDto = new ProductDto(productEntity);
            productDtoList.add(productDto);
        });

        return productDtoList;
    }

    /*
    // IMPORTAÇÃO DO LOG
    private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);

    // VARIÁVEL DO REPOSITORY
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    // CONSTRUTOR
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDto salvar(ProductDto product) {
        // CONVERSÃO DO ENTITY PARA DTO:
        ProductEntity productEntity = new ProductEntity(product);
        // BUSCA CATEGORY DENTRO DE ENTITY, MANDA PARA REPOSITORY, O QUE RETORNA SOBREESCREVE ENTITY
        productEntity.setCategory(categoryRepository.saveAndFlush(productEntity.getCategory())); //salvar a categoria

        return new ProductDto(productRepository.save(productEntity));
    }

    @Override
    public ProductDto buscarId(Integer id) {
        return new ProductDto(productRepository.getById(id));
    }

    @Override
    public List<ProductDto> buscarTodos() {
        // SALVA DENTRO DE UMA LISTA DE ENTITY, PERCORRE A LISTA E CONVERTE EM DTO NUMA OUTRA LISTA
        List<ProductEntity> productEntityList = new ArrayList<>();
        productEntityList.addAll(productRepository.findAll());
        List<ProductDto> productDtoList = new ArrayList<>();
        // PERCORRER A LISTA
        productEntityList.forEach(productEntity -> {
            ProductDto productDto = new ProductDto((productRepository.getById(productEntity.getId())));
            productDtoList.add(productDto);
        });
        return productDtoList;
    }

   @Override
    public ProductDto atualizar(ProductDto product) {
        // BUSCA PARA ENTÃO ATUALIZAR
        ProductEntity productEntity = productRepository.getById(product.getId());
        CategoryEntity categoryEntity = categoryRepository.getById(product.getId());

        if(product.getTitle() != null && product.getDescription() != null && product.getImageUrl() != null){
            productEntity.setTitle(productEntity.getTitle());
            productEntity.setDescription(productEntity.getDescription());
            productEntity.setImageUrl(productEntity.getImageUrl());
        }

        if(product.getCategory() != null){
            // CASO O PRODUCT POSSUA ID, SET ESSE VALOR, COMPARA COM CATEGORY QUAL O CORRESPONDENTE
            categoryEntity.setName(product.getCategory().getName());
            productEntity.setCategory(categoryEntity);
        }
        ProductDto productAtual = new ProductDto(productRepository.saveAndFlush(productEntity));
        return productAtual;
    }

    @Override
    public void deletar(Integer id) {
        if(productRepository.getById(id) == null){
            logger.info("Not found.");
        }
        productRepository.deleteById(id);
    }*/
}
