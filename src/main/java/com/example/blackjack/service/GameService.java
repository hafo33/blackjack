package com.example.blackjack.service;

import com.example.blackjack.dto.GameStatusDTO;
import com.example.blackjack.model.Game;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GameService {
    private Game game;

    // Constructor para inicializar el juego
    public GameService() {
        this.game = new Game();        
    }

    // Método para inicializar un nuevo juego
    public void startGame() {
        this.game = new Game();
        // Repartir las cartas de inicio al jugador y al crupier
        game.getPlayer().addCard(game.getDeck().dealCard());
        game.getPlayer().addCard(game.getDeck().dealCard());
        game.getDealer().addCard(game.getDeck().dealCard());
        game.getDealer().addCard(game.getDeck().dealCard());
    }

    // Método para que el jugador pida una carta
    public String hit() {
        if (game.isGameOver()) {
            return "El juego ha terminado.";
        }

        game.getPlayer().addCard(game.getDeck().dealCard());
        if (game.getPlayer().getScore() > 21) {
            game.setGameOver(true);
            return "El jugador se pasa.";
        }

        return "El jugador pide carta.";
    }

    // Método para que el jugador se plante (stand)
    public String stand() {
        if (game.isGameOver()) {
            return "El juego ha terminado.";
        }

        // Turno del crupier para seguir pidiendo cartas
        while (game.getDealer().getScore() < 17) {
            game.getDealer().addCard(game.getDeck().dealCard());
        }

        game.setGameOver(true);
        if (game.getDealer().getScore() > 21) {
            return "El crupier se pasa, gana el jugador.";
        }

        if (game.getDealer().getScore() > game.getPlayer().getScore()) {
            return "El crupier gana.";
        }

        if (game.getDealer().getScore() == game.getPlayer().getScore()) {
            return "Empate.";
        }

        return "El jugador gana.";
    }

    // Método para obtener el estado actual del juego
    public Game getGame() {
        return game;
    }

    public GameStatusDTO getGameStatus() {
      return new GameStatusDTO(
          game.getPlayer().getHand().stream().map(card -> card.toString()).collect(Collectors.toList()),
          game.getPlayer().getScore(),
          game.getDealer().getHand().stream().map(card -> card.toString()).collect(Collectors.toList()),
          game.getDealer().getScore(),
          game.isGameOver()
      );
  }
}

