package ua.skillsup.services;

import ua.skillsup.services.DTO.UserDTO;

import java.util.List;

public interface UserService {

    void create(UserDTO user);

    List<UserDTO> findAll();

    void delete(Long id);

    void update(Long id, UserDTO user);

    UserDTO findById(Long id);

}
