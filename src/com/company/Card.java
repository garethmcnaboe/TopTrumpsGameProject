package com.company;

import java.util.Random;

public class Card {

    //Fields
    private String playerName;
    private String playerCountry;
    private int shooting;
    private int passing;
    private int tackling;
    private int pace;

    //General Constructor
    public Card(String playerName, String playerCountry, int shooting, int passing, int tackling, int pace){
        this.playerName = playerName;
        this.playerCountry = playerCountry;
        this.shooting = shooting;
        this.passing = passing;
        this.tackling = tackling;
        this.pace = pace;
    }

    //Getter methods for each of the values.
    public String getPlayerName(){
        return playerName;
    }

    public String getPlayerCountry(){ return playerCountry; }

    public int getShooting(){
        return shooting;
    }

    public int getPassing(){
        return passing;
    }

    public int getTackling(){
        return tackling;
    }

    public int getPace(){
        return pace;
    }

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

    //Method to return particular attribute for comparison based on input of particular number.
    public int getAttribute(int attributeNumber){

        switch (attributeNumber) {
            case 1 -> {
                return shooting;
            }
            case 2 -> {
                return passing;
            }
            case 3 -> {
                return tackling;
            }
            case 4 -> {
                return pace;
            }
            default -> throw new IllegalStateException("Unexpected value: " + attributeNumber);
        }
    }
}
