package ua.skillsup.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.services.DTO.ProductDTO;
import ua.skillsup.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final static Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<ProductDTO> findAll(){
        log.info("Find all products.");
        return productService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductDTO product){
        log.info("Create product data:{}", product);
        productService.create(product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        log.info("Delete product id:{}", id);
        productService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") Long id, @RequestBody ProductDTO product){
        log.info("Create product id:{}, data:{}", id, product);
        productService.update(id, product);
    }
}
