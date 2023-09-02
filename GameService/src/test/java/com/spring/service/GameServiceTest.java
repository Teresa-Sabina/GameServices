package com.spring.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.spring.model.Game;
import com.spring.repository.GameRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class GameServiceTest {
    @Mock
    private GameRepository gameRepository;

    @Autowired
    @InjectMocks
    private GameServiceImpl gameService;
    private Game game1;
    private Game game2;
    private List<Game> gameList;

    @BeforeEach
    public void setUp() {
        gameList = new ArrayList<>();
        game1 = new Game(1, "Solitaire");
        game2 = new Game(2, "Pinball");
        gameList.add(game1);
        gameList.add(game2);
    }

    @AfterEach
    public void tearDown() {
        game1 = game2 = null;
        gameList = null;
    }

    //To return list of all products
    @Test
    void givenCallToGetAllUsersThenShouldReturnListOfAllGame() {
        gameService.addGame(game1);
        gameService.addGame(game2);

        gameService.getAllGames();
        gameService.getAllGames();
        gameService.getAllGames();
        gameService.getAllGames();

        verify(gameRepository, times(1)).findAll();
    }

    //to return product by id number
    @Test
    void givenGamedThenShouldReturnGameWithThatId() {
        when(gameRepository.findById(anyInt())).thenReturn(Optional.of(game1));
        gameService.addGame(game1);
        gameService.addGame(game2);

        gameService.getGame(game1.getId());
        gameService.getGame(game2.getId());

        verify(gameRepository, times(1)).findById(game1.getId());
    }

    @Test
    void givenGameToSaveThenShouldEvictCache() {
        when(gameRepository.save(any())).thenReturn(game1);
        when(gameRepository.findById(anyInt())).thenReturn(Optional.of(game1));
        gameService.addGame(game1);

        gameService.getGame(game1.getId());
        gameService.getGame(game1.getId());

        verify(gameRepository, times(1)).findById(game1.getId());
    }
	
}
