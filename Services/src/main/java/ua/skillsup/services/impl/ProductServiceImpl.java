package ua.skillsup.services.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.DAO.model.Product;
import ua.skillsup.DAO.repo.ProductDAO;
import ua.skillsup.services.DTO.ProductDTO;
import ua.skillsup.services.ProductService;
import ua.skillsup.services.convert.ProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductDAO productDAO;
    private final ProductConvert productConvert;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO, ProductConvert productConvert) {
        this.productDAO = productDAO;
        this.productConvert = productConvert;
    }

    @Override
    @Transactional
    public void create(ProductDTO product) {
        productDAO.create(productConvert.toEntity(product));
    }

    @Override
    @Transactional
    public List<ProductDTO> getAll() {
        List<Product> products = productDAO.getAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product: products){
            productDTOS.add(productConvert.toDto(product));
        }
        return productDTOS;
    }
}
