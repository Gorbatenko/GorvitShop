package ua.skillsup.DAO.repo.impl;

import org.springframework.stereotype.Repository;
import ua.skillsup.DAO.model.User;
import ua.skillsup.DAO.repo.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final Map<Long,User> userMap = new HashMap<>();
    private static volatile long idGenerator =1L;

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> findAllUsers =
                entityManager.createQuery("SELECT u FROM User u", User.class);

        return findAllUsers.getResultList();
    }

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
        Query query =
                entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Long id, User user) {
        user.setId(id);
        entityManager.merge(user);
    }
}
