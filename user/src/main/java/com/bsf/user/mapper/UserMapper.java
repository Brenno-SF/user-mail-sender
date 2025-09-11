package com.bsf.user.mapper;

import com.bsf.user.domain.UserModel;
import com.bsf.user.dto.UserDTO;

public class UserMapper {
    public static UserModel toEntity(UserDTO dto){
        return new UserModel(
                dto.userId(),
                dto.name(),
                dto.email()
        );
    }
    public static UserDTO toDto(UserModel model){
        return new UserDTO(
                model.getUserId(),
                model.getName(),
                model.getEmail()
        );
    }

}
