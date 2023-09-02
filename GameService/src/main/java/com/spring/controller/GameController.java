package com.spring.controller;

import com.spring.model.Game;
import com.spring.repository.GameRepository;
import com.spring.service.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/version1/")
public class GameController {

	
    private GameService gameService;

    //private static final Logger logger = LoggerFactory.getL(GameController.class);
    
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("game")
    public ResponseEntity<Game> saveAGame(@RequestBody Game game){
    	Game saveGame = gameService.addGame(game);
    	return new ResponseEntity<>(saveGame,HttpStatus.OK);
    }

    @GetMapping("Games")
    public ResponseEntity<List<Game>> getAllGames(){

        return new ResponseEntity<List<Game>>(
                (List <Game>) gameService.getAllGames(),HttpStatus.OK);
    }

    @GetMapping("game/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable int id){
        Game retrievedGame = gameService.getGame(id);
        return new ResponseEntity<Game>(retrievedGame, HttpStatus.OK);
    }


}
