package com.company;

import java.util.Scanner;

public class HomeScreen {

    public static void printHomeScreen() {

        System.out.println("Welcome to Italy '90 Top Trumps");
        System.out.println();
        System.out.println("_____________________________________________________");
        String input = "";
        String input1 = "";
        Scanner sc = new Scanner(System.in);
        while(!input1.equals("Y")){
            System.out.print("Player 1: Please input 'Y' when you are ready to play:");
            input = sc.next();
            input1 = input.toUpperCase();
        }
    }
}
