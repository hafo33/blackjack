package com.example.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;
    private int score;
    private int aces;

    // constructor para inicializar la mano y puntaje

    public Player() {
        this.hand = new ArrayList<>();
        this.score = 0;
        this.aces = 0;
        
    }

    //metodo para añadir cartas ala mano
    public void addCard(Card card) {
        hand.add(card);
        score += getCardValue(card);
        if ("A".equals(card.getValue())) {
            aces++;
            
        }
        adjustForAces();
    }

    //metodo para obtener el valor de una carta
    private int getCardValue(Card card) {
        switch (card.getValue()) {
            case "A": return 11;
            case "K": case "Q": case "J": return 10;             
                     
            default: return Integer.parseInt(card.getValue());
                
        }
    }

    // ajustar puntaje si hay ases y el puntaje es mas que 21
    private void adjustForAces() {
        while ( score > 21 && aces > 0) {
            score -= 10;
            aces--;
            
        }
    }

    //getters
    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }
    
}
