package ua.skillsup.services.convert.impl;

import org.springframework.stereotype.Component;
import ua.skillsup.DAO.model.Product;
import ua.skillsup.services.DTO.ProductDTO;
import ua.skillsup.services.convert.ProductConvert;

@Component
public class ProductConvertImpl implements ProductConvert {

    @Override
    public Product toEntity(ProductDTO dto) {
        return new Product(dto.getName(), dto.getCategory(), dto.getColor(), dto.getParameter(), dto.getCount(), dto.getPrice(), null);
    }

    @Override
    public ProductDTO toDto(Product entity) {
        return new ProductDTO(entity.getName(),entity.getCategory(),entity.getColor(),entity.getParameter(),entity.getCount(),entity.getPrice());
    }
}