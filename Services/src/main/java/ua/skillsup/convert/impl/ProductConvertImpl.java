package ua.skillsup.convert.impl;

import ua.skillsup.DAO.model.Product;
import ua.skillsup.DTO.ProductDTO;
import ua.skillsup.convert.ProductConvert;

public class ProductConvertImpl implements ProductConvert {

    @Override
    public Product toEntity(ProductDTO dto) {
        return new Product(dto.getName(), dto.getCategory(), dto.getColor(), dto.getParameter(), dto.getCount(), dto.getPrice(), null);
    }

    @Override
    public ProductDTO toDto(Product entity) {
        return new ProductDTO(entity.getName(), entity.getCategory(), entity.getColor(), entity.getParameter(), entity.getCount(), entity.getPrice());
    }
}
