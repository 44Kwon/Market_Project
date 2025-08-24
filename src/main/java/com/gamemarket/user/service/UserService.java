package com.gamemarket.user.service;

import com.gamemarket.user.dto.PointResponse;
import com.gamemarket.user.dto.UserResponseDto;
import com.gamemarket.user.entity.User;
import com.gamemarket.user.mapper.UserMapper;
import com.gamemarket.user.repository.UserRepository;
import com.gamemarket.user.service.dto.UserServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;
//    회원가입	POST	/api/users	username, email, password, role
//    로그인	POST	/api/auth/login	JWT 발급, 세션 생성
//    회원 조회	GET	/api/users/{id}	유저 정보 조회 (포인트 포함)
//    회원 포인트 조회	GET	/api/users/{id}/points	현재 잔여 포인트 조회
//    회원 포인트 충전	POST	/api/users/{id}/points/charge	포인트 충전 (PointHistory 기록)

    //회원가입
    public Long createUser(UserServiceDto.Create create) {
        User createUser = userMapper.createToUser(create);
        //검증로직
        userValidator.validate(createUser);

        //저장
        User savedUser = userRepository.save(createUser);
        return savedUser.getId();
    }

    //비밀번호 변경
    public void updatePassword(Long userId, UserServiceDto.UpdatePassword updatePassword) {
        //검증로직
        userValidator.validateNewPassword(updatePassword);

        User user = userValidator.findVerifiedUser(userId);
        user.updatePassword(updatePassword.getNewPw());
    }

    //회원조회
    @Transactional(readOnly = true)
    public UserResponseDto getUser(Long userId) {
        User user = userValidator.findVerifiedUser(userId);
        return userMapper.toUserResponseDto(user);
    }


    //포인트 조회
    public PointResponse getPoint(Long userId) {
        User user = userValidator.findVerifiedUser(userId);
        return new PointResponse(user.getPoint());
    }
}
