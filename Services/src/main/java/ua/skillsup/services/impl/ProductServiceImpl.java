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
        List<ProductDTO> productDTOs = new ArrayList<>();
        for(Product product: products){
            productDTOs.add(productConvert.toDto(product));
        }
        return productDTOs;
    }

    @Override
    @Transactional
    public List<ProductDTO> findAll() {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productDAO.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, ProductDTO product) {
        Product entity = productConvert.toEntity(product);
        entity.setId(id);
        productDAO.update(id, entity);
    }


}
