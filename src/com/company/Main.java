package com.company;

import java.util.Random;

public class Main {

    public static Card[] cardArray;

    public static void main(String[] args) {

        //calling method to show home screen
        HomeScreen.printHomeScreen();

        //create an array called cardArray of 10 card objects.
        Card[] cardArray = new Card[10];

        //calling method which will create objects which will contain the player card data.
        CardData.createCards(cardArray);

        //calling method to shuffle the deck of cards
        Deck.shuffleArray(cardArray);
    }
}
