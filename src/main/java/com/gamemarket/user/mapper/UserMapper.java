package com.gamemarket.user.mapper;

import com.gamemarket.user.controller.dto.UserControllerDto;
import com.gamemarket.user.dto.UserResponseDto;
import com.gamemarket.user.entity.User;
import com.gamemarket.user.service.dto.UserServiceDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserServiceDto.create createToUserServiceDto(UserControllerDto.create create);
    UserServiceDto.updatePassword updatePasswordToUserServiceDto(UserControllerDto.updatePassword updatePassword);
    User createToUser(UserServiceDto.create create);
    UserResponseDto toUserResponseDto(User user);
}
