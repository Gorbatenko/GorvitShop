package ua.skillsup.DAO.repo;

import ua.skillsup.DAO.model.Product;
import java.util.List;

public interface ProductDAO {

    void create(Product product);

    List<Product> getAll();

    void delete(Long id);

    void update(Long id, Product entity);
}
