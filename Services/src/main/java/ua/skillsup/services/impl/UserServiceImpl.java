package ua.skillsup.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.DAO.model.User;
import ua.skillsup.DAO.repo.UserDAO;
import ua.skillsup.services.DTO.UserDTO;
import ua.skillsup.services.convert.UserConvert;
import ua.skillsup.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDao;
    private final UserConvert userConvert;

    @Autowired
    public UserServiceImpl(UserDAO userDao,UserConvert userConvert) {
        this.userDao = userDao;
        this.userConvert = userConvert;
    }

    @Override
    public void create(UserDTO user) {

        userDao.create(userConvert.toEntity(user));
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userDao.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user: users){
            userDTOS.add(userConvert.toDto(user));
        }
        return userDTOS;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, UserDTO user) {
        User entity = userConvert.toEntity(user);
        entity.setId(id);
        userDao.update(id, entity);
    }

}