package ua.skillsup.services;

import ua.skillsup.services.DTO.ProductDTO;

import java.util.List;

public interface ProductService {

    void create(ProductDTO product);

    List<ProductDTO> getAll();
}
