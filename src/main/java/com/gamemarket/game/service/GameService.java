package com.gamemarket.game.service;


import com.gamemarket.game.dto.GameListResponseDto;
import com.gamemarket.game.dto.GameResponseDto;
import com.gamemarket.game.entity.Game;
import com.gamemarket.game.repository.GameRepository;
import com.gamemarket.game.service.dto.GameServiceDto;
import com.gamemarket.user.service.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GameService {
    private final GameRepository gameRepository;
    private final GameValidator gameValidator;
    private final UserValidator userValidator;

    //게임 등록(관리자)
    public Long createGame(Long userId,GameServiceDto.CreateAndUpdateDto create) {
        Game game = create.toGame();
        //검증
        gameValidator.validateGame(userId, game.getName());
        return gameRepository.save(game).getId();
    }

    //게임 수정(관리자)
    public GameResponseDto updateGame(Long userId, Long gameId, GameServiceDto.CreateAndUpdateDto update) {
        Game updateGame = update.toGame();
        //검증
        gameValidator.validateGame(userId, updateGame.getName());

        Game game = gameValidator.findVerifiedGame(gameId);
        game.updateGame(updateGame.getName(), updateGame.getDescription());

        return game.toResponseDto();
    }

    //게임 목록 보여주기
    @Transactional(readOnly = true)
    public List<GameListResponseDto> getGames() {
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(Game::toListResponseDto)
                .toList();
    }


    //게임 삭제(관리자)
    public void deleteGame(Long userId, Long gameId) {
        //관리자인지(검증)
        userValidator.ifAdmin(userId);

        Game game = gameValidator.findVerifiedGame(gameId);

        //아직 삭제 구현 X
        //향후 연관관계 고려하여 bulk delete로 변경 예정
        //외래키를 가진쪽부터 삭제해야함, 만약 남기고 싶다면 외래키를 null로 변경하여 남기기
        //거래 데이터는 남기기
        //1. transaction의 item_id, game_id null로 변경
        //2. Inventories의 데이터 삭제 -> sale_post 삭제 -> items 삭제 -> game 삭제
    }
}
