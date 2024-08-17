package com.example.blackjack.dto;

import java.util.List;

public class GameStatusDTO {
    private List<String> playerHand;
    private int playerScore;
    private List<String> dealerHand;
    private int dealerScore;
    private boolean gameOver;

    // Constructor
    public GameStatusDTO(List<String> playerHand, int playerScore, List<String> dealerHand, int dealerScore, boolean gameOver) {
        this.playerHand = playerHand;
        this.playerScore = playerScore;
        this.dealerHand = dealerHand;
        this.dealerScore = dealerScore;
        this.gameOver = gameOver;
    }

    // Getters y setters
    public List<String> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(List<String> playerHand) {
        this.playerHand = playerHand;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public List<String> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(List<String> dealerHand) {
        this.dealerHand = dealerHand;
    }

    public int getDealerScore() {
        return dealerScore;
    }

    public void setDealerScore(int dealerScore) {
        this.dealerScore = dealerScore;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
