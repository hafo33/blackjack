package com.example.blackjack.controller;

import com.example.blackjack.dto.GameStatusDTO;
import com.example.blackjack.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    // Endpoint para obtener el estado actual del juego       
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/status")
    public GameStatusDTO getGameStatus() {
        return gameService.getGameStatus();
    }


    // Endpoint para iniciar un nuevo juego
    @PostMapping("/start")
    public String startGame() {
        gameService.startGame();
        return "El juego ha comenzado. ¡Buena suerte!";
    }

    // Endpoint para que el jugador pida una carta
    @PostMapping("/hit")
    public String hit() {
        return gameService.hit();
    }

    // Endpoint para que el jugador se plante (stand)
    @PostMapping("/stand")
    public String stand() {
        return gameService.stand();
    }

    
}
