package ua.skillsup.services;

import ua.skillsup.services.DTO.ProductDTO;

import java.util.List;

public interface ProductService {

    void create(ProductDTO product);

    List<ProductDTO> getAll();

    List<ProductDTO> findAll();

    void delete(Long id);

    void update(Long id, ProductDTO product);
}
