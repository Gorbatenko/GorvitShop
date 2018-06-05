package ua.skillsup.services.convert.impl;

import org.springframework.stereotype.Component;
import ua.skillsup.DAO.model.User;
import ua.skillsup.services.DTO.UserDTO;
import ua.skillsup.services.convert.UserConvert;

@Component
public class UserConvertImpl implements UserConvert {

    @Override
    public User toEntity(UserDTO dto) {
        return new User(dto.getFirstName(),dto.getLastName(),dto.getAge(),null);
    }

    @Override
    public UserDTO toDto(User entity) {
        return new UserDTO(entity.getFirstName(),entity.getLastName(),entity.getAge());
    }
}
