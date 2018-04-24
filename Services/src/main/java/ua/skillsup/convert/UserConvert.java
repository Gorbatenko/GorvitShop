package ua.skillsup.convert;

import ua.skillsup.DAO.model.User;
import ua.skillsup.DTO.UserDTO;

public interface UserConvert {

    User toEntity(UserDTO dto);

    UserDTO toDto(User entity);

}
