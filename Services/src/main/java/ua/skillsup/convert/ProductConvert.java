package ua.skillsup.convert;

import ua.skillsup.DAO.model.Product;
import ua.skillsup.DTO.ProductDTO;

public interface ProductConvert {

    Product toEntity(ProductDTO dto);

    ProductDTO toDto(Product entity);
}
