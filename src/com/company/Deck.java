package com.company;

import java.util.Random;

public class Deck {

    //Fisher-Yates shuffle
    public static void shuffleArray(Card[] cardArray){
        Random rnd = new Random();

        for(int i = cardArray.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);

            //Swap entries in the array.
            Card a = cardArray[index];
            cardArray[index] = cardArray[i];
            cardArray[i] = a;
        }
        System.out.println("Shuffle of deck complete.");
    }
}
