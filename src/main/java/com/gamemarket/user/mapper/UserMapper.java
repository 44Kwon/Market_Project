package com.gamemarket.user.mapper;

import com.gamemarket.user.controller.dto.UserControllerDto;
import com.gamemarket.user.dto.UserResponseDto;
import com.gamemarket.user.entity.User;
import com.gamemarket.user.service.dto.UserServiceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserServiceDto.Create createToUserServiceDto(UserControllerDto.Create create);
    UserServiceDto.UpdatePassword updatePasswordToUserServiceDto(UserControllerDto.UpdatePassword updatePassword);
    User createToUser(UserServiceDto.Create create);
    UserResponseDto toUserResponseDto(User user);
}
