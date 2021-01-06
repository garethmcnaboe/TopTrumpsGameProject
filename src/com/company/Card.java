package com.company;

import java.util.Random;

public class Card {

    //Fields
    public String playerName;
    public String playerCountry;
    public int shooting;
    public int passing;
    public int tackling;
    public int pace;

    //General Constructor
    public Card(String playerName, String playerCountry, int shooting, int passing, int tackling, int pace) {
        this.playerName = playerName;
        this.playerCountry = playerCountry;
        this.shooting = shooting;
        this.passing = passing;
        this.tackling = tackling;
        this.pace = pace;
    }

    //Getter methods for each of the values.
    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerCountry() {
        return playerCountry;
    }

    public int getShooting() {
        return shooting;
    }

    public int getPassing() {
        return passing;
    }

    public int getTackling() {
        return tackling;
    }

    public int getPace() {
        return pace;
    }

    //Fisher-Yates Shuffle
    public static void shuffleArray(Card[] cardArray) {
        Random rnd = new Random();

        for (int i = cardArray.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);

            //Swap entries in the array.
            Card a = cardArray[index];
            cardArray[index] = cardArray[i];
            cardArray[i] = a;
        }
        //System.out.println("Shuffle of deck complete."); //used only for debugging to identify where errors occur.
    }
}