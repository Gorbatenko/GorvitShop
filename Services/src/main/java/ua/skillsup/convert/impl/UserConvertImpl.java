package ua.skillsup.convert.impl;

import ua.skillsup.DAO.model.User;
import ua.skillsup.DTO.UserDTO;
import ua.skillsup.convert.UserConvert;

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
