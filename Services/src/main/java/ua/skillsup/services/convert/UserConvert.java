package ua.skillsup.services.convert;

import ua.skillsup.DAO.model.User;
import ua.skillsup.services.DTO.UserDTO;

public interface UserConvert {

    User toEntity(UserDTO dto);
    UserDTO toDto(User entity);

}
