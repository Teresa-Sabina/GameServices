package com.spring.service;

import com.spring.model.Game;

import java.util.List;

public interface GameService {

    Game addGame(Game game);
    Game getGame(int id);
    List<Game> getAllGames();


}
