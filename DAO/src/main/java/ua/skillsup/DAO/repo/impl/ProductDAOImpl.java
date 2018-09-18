package ua.skillsup.DAO.repo.impl;

import org.springframework.stereotype.Repository;
import ua.skillsup.DAO.model.Product;
import ua.skillsup.DAO.repo.ProductDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> getAllProducts =
                entityManager.createQuery("SELECT p FROM Product p", Product.class);

        return getAllProducts.getResultList();
    }

    @Override
    public void delete(Long id) {
        Query query =
                entityManager.createQuery("DELETE FROM Product p WHERE p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Long id, Product entity) {
        entity.setId(id);
        entityManager.merge(entity);
    }
}
