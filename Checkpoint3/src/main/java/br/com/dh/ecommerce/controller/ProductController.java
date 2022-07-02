package br.com.dh.ecommerce.controller;

import br.com.dh.ecommerce.dto.ProductDto;
import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import br.com.dh.ecommerce.service.impl.ProductServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    //Método GET - 'https://ctdcommerce.com/products':
    // este end-point deverá disponibilizar os dados de todos os produtos cadastrados em um JSON
    @GetMapping
    public ResponseEntity<List<ProductDto>> metodo(){
        return ResponseEntity.ok(productService.listAll());
    }

    //Método GET - https://ctdcommerce.com/products/1:
    // este end-point deverá disponibilizar os dados de um produto específico em um JSON
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> metodo2(@PathVariable Integer id){
        return ResponseEntity.ok(productService.searchById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> createProduct (@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    @GetMapping("/category/{type}")
    public ResponseEntity<Optional<List<ProductEntity>>> findByCategory(@PathVariable String type){
        return ResponseEntity.ok(productService.listCategory(type));
    }

    /*
    // IMPORTAÇÃO DO LOG
    private static final Logger logger = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody ProductDto product){
        ResponseEntity<String> response = null;
        if(productService.salvar(product) != null){
            logger.info(product.getTitle() + " " + product.g);
        }
    }

    //Método GET - 'https://ctdcommerce.com/products':
    // este end-point deverá disponibilizar os dados de todos os produtos cadastrados em um JSON
    @GetMapping
    public ResponseEntity<ProductDto> metodo(){
        return null;
    }

    //Método GET - https://ctdcommerce.com/products/1:
    // este end-point deverá disponibilizar os dados de um produto específico em um JSON
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> metodo2(@PathVariable Integer id){
        return null;
    }
*/
}
