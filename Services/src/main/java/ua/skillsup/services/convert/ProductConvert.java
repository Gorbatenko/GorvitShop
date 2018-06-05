package ua.skillsup.services.convert;

import ua.skillsup.DAO.model.Product;
import ua.skillsup.services.DTO.ProductDTO;

public interface ProductConvert {

    Product toEntity(ProductDTO dto);
    ProductDTO toDto(Product entity);
}
