package com.example.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    //constructor para inicializar y barajar el mazo
    public Deck() {
String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
cards = new ArrayList<>();

// Crear las cartas del mazo
for (String suit : suits) {
    for (String value : values) {
        cards.add(new Card(suit, value));
    }
}

//Barajar el mazo
Collections.shuffle(cards);

    }
// Metodo para repartir una carta
public Card dealCard() {
    if (!cards.isEmpty()) {
        return cards.remove(0);
    }
    return null;
}
// Metodo para obtener el numero de cartas restantes en el mazo
public int cardsRemaining() {
    return cards.size();
    
}

    
}
