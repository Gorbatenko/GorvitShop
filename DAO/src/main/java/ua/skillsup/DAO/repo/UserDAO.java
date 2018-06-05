package ua.skillsup.DAO.repo;

import ua.skillsup.DAO.model.User;

import java.util.List;

public interface UserDAO {

    void create(User user);

    List<User> findAll();

    User get(Long id);

    void delete(Long id);

    void update(Long id, User user);

}
