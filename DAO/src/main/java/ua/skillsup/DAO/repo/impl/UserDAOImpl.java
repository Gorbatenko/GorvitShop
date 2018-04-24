package ua.skillsup.DAO.repo.impl;

import ua.skillsup.DAO.model.User;
import ua.skillsup.DAO.repo.UserDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOImpl implements UserDAO {

    private final Map<Long,User> userMap = new HashMap<>();
    private static volatile long idGenerator =1L;

    @Override
    public void create(User user) {
        user.setId(idGenerator++);
        userMap.put(user.getId(),user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}
