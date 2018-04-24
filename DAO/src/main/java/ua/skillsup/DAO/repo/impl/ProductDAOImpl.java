package ua.skillsup.DAO.repo.impl;

import ua.skillsup.DAO.model.Product;
import ua.skillsup.DAO.repo.ProductDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAOImpl implements ProductDAO {

    private final Map<Long,Product> productMap = new HashMap<>();
    private static volatile long idGenerator =1L;

    @Override
    public void create(Product product) {
        product.setId(idGenerator++);
        productMap.put(product.getId(),product);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }
}
