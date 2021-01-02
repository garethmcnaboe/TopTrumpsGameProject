package com.company;

import java.util.Scanner;

public class Console {

    //Prints Home Screen and asks player are they ready to play.
    public static void printHomeScreen() {

        System.out.println("Welcome to Italy '90 Top Trumps");
        System.out.println();
        System.out.println("_____________________________________________________");
        String input = "";
        String input1 = "";
        Scanner sc = new Scanner(System.in);
        while(!input1.equals("Y")){
            System.out.print("Player 1: Please input 'Y' when you are ready to play:");
            input = sc.nextLine();
            input1 = input.toUpperCase();
        }
    }

    //Asks player if they would like to play another game.
    public static boolean anotherGame() {
        boolean playAnotherGame;
        playAnotherGame = false;
        System.out.println("Would you like to play another game of Top Trumps");
        System.out.println("_____________________________________________________");
        String input = "";
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