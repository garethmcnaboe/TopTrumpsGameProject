package com.company;

import java.util.Scanner;

public class Console {

    //Prints Home Screen and asks player are they ready to play.
    public static void printHomeScreen() {
        System.out.println("Welcome to Italy '90 Top Trumps");
        System.out.println();
        System.out.println("_____________________________________________________");
        String input;
        String input1 = "";
        Scanner sc = new Scanner(System.in);
        while(!input1.equals("Y")){
            System.out.print("Player 1: Please input 'Y' when you are ready to play:");
            input = sc.nextLine();
            input1 = input.toUpperCase();
        }
    }

    //Method allows user to select the difficulty level they wish to play the game at.
    public static void setLevel() {
        System.out.println("Please select the level you would like to play at.");
        String input;
        String input1 = "";
        boolean easy = true;
        Scanner sc = new Scanner(System.in);
        while (!((input1.equals("E"))||(input1.equals("D")))) {
            System.out.print("Please input 'E' to play at easy level or 'D' to play at difficult level: ");
            input = sc.nextLine();
            input1 = input.toUpperCase();
        }
        if(input1.equals("E")){
            System.out.println("You have selected the easy level.");
            easy = true;
        }
        if(input1.equals("D")){
            System.out.println("You have selected the difficult level.");
            easy = false;
        }
        Round.setLevel(easy);
    }

    //Asks player are they ready to proceed to the next round of the game.
    public static void anotherRound() {
        String input;
        String input1 = "";
        Scanner sc = new Scanner(System.in);
        while (!input1.equals("P")) {
            System.out.print("Player 1: Please input 'P' to proceed to the next Round: ");
            input = sc.nextLine();
            input1 = input.toUpperCase();
        }
    }

    //Asks player if they would like to play another game.
    public static boolean anotherGame() {
        boolean playAnotherGame = false;
        System.out.println("Would you like to play another game of Top Trumps");
        System.out.println("_____________________________________________________");
        String input;
        String input1 = "";
        Scanner sc = new Scanner(System.in);
        while (!((input1.equals("Y"))||(input1.equals("N")))) {
            System.out.print("Please input 'Y' to play again or 'N' to exit");
            input = sc.nextLine();
            input1 = input.toUpperCase();
        }
        if(input1.equals("Y")){
            playAnotherGame = true;
        }
        if(input1.equals("N")) {
            playAnotherGame = false;
        }
        return playAnotherGame;
    }

    //Prints a farewell message.
    public static void end() {
        System.out.println("Thank you for playing Top Trumps");
        }
    }