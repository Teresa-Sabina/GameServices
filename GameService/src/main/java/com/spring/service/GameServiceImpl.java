package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.spring.model.Game;
import com.spring.repository.GameRepository;
import java.util.List;


@CacheConfig(cacheNames = "game")
@Service
public class GameServiceImpl implements GameService{

	private GameRepository  gameRepository;
	
	@Autowired
	public void setGameRepository(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
		
	public GameServiceImpl() {
	}
	
	@Autowired
	public GameServiceImpl(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	@Caching(evict = {@CacheEvict(value = "allgamecache", allEntries = true),
            @CacheEvict(value = "gamecache", key = "#game.id")
    })
    @Override
    public Game addGame(Game game) {

        return gameRepository.save(game);
    }

    @Cacheable(value = "gamecache",key ="#id" )
    @Override
    public Game getGame(int id) {

        System.out.println("Data is about to be retrieved from database ");
        Game retrievedGame = null;
        retrievedGame = gameRepository.findById(id).get();
        System.out.println("Data retrieved from database");
        return retrievedGame;
    }

    @Cacheable(value = "allgamecache")
    @Override
    public List<Game> getAllGames() {

        System.out.println("Data is retrieved from database ");
        return (List<Game>) gameRepository.findAll();
    }

}
