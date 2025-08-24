package com.gamemarket.user.service;

import com.gamemarket.exception.BusinessLogicException;
import com.gamemarket.exception.ExceptionCode;
import com.gamemarket.user.entity.User;
import com.gamemarket.user.repository.UserRepository;
import com.gamemarket.user.service.dto.UserServiceDto;
import org.springframework.stereotype.Component;

/**
 * 입력값에 대한 검증 로직을 담당하는 클래스
 */
@Component
public class UserValidator {

    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validate(User user) {
        validateUsername(user.getUsername());
        validateEmail(user.getEmail());
    }

    public void validateUsername(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new BusinessLogicException(ExceptionCode.USER_USERNAME_DUPLICATED);
        }
    }

    public void validateEmail(String email) {
        if (userRepository.existsByUsername(email)) {
            throw new BusinessLogicException(ExceptionCode.USER_EMAIL_DUPLICATED);
        }
    }

    public void validateNewPassword(UserServiceDto.UpdatePassword updatePasswordDto) {
        if (updatePasswordDto.getCurrentPw().equals(updatePasswordDto.getNewPw())) {
            throw new BusinessLogicException(ExceptionCode.PASSWORD_SAME_AS_OLD);
        }
    }

    // userId로 유저 존재 여부 검증
    public User findVerifiedUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
    }

    //관리자인지
    public void ifAdmin(Long userId) {
        if (!userRepository.existsByIdAndRole(userId, User.Role.ADMIN)) {
            throw new BusinessLogicException(ExceptionCode.INVALID_ACCESS);
        }
    }
}
