package com.example.blackjack.model;

public class Game {
    private Deck deck;
    private Player player;
    private Player dealer;
    private boolean gameOver;

    // Constructor para inicializar el juego
    public Game() {
        this.deck = new Deck();
        this.player = new Player();
        this.dealer = new Player();
        this.gameOver = false;

        // Repartir dos cartas al jugador y al crupier
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
    }

    // Getters
    public Deck getDeck() {
        return deck;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    // Setters
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
