package com.company;

import java.util.Random;

public class Main {

    public static Card[] cardArray;

    public static void main(String[] args) {

        //create an array called card of 10 card objects.
        Card[] cardArray = new Card[10];

        //Calling method which will create objects which will contain the player card data.
        CardData.createCards(cardArray);

        //Calling method to shuffle the deck of cards
        Deck.shuffleArray(cardArray);


    }
}
