package com.gamemarket.game.service;

import com.gamemarket.exception.BusinessLogicException;
import com.gamemarket.exception.ExceptionCode;
import com.gamemarket.game.entity.Game;
import com.gamemarket.game.repository.GameRepository;
import com.gamemarket.user.entity.User;
import com.gamemarket.user.repository.UserRepository;
import com.gamemarket.user.service.UserValidator;
import org.springframework.stereotype.Component;

/**
 * Game 과 관련된 검증 로직 담당
 */
@Component
public class GameValidator {
    private final GameRepository gameRepository;
    private final UserValidator userValidator;

    public GameValidator(GameRepository gameRepository, UserValidator userValidator) {
        this.gameRepository = gameRepository;
        this.userValidator = userValidator;
    }

    public void validateGame(Long userId,String name){
        //관리자인지 확인
        userValidator.ifAdmin(userId);
        //게임 이름 중복 확인
        if (gameRepository.existsByName(name)) {
            throw new BusinessLogicException(ExceptionCode.GAME_ALREADY_EXIST);
        }
    }

    public Game findVerifiedGame(Long gameId) {
        return gameRepository.findById(gameId).orElseThrow(() -> new BusinessLogicException(ExceptionCode.GAME_NOT_FOUND));
    }
}
