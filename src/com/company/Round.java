package com.company;

import java.util.Scanner;

public class Round {

    private static int player1Score;
    private static int computerScore;

    public static void gameRound(LinkedList hand1, LinkedList hand2, int roundCount) {
        System.out.println("Player 1 card for this round is as follows:");
        System.out.println("___________________________________________");
        LinkedList.printCard(hand1,roundCount);

        Scanner sc = new Scanner(System.in);
        System.out.println("Please select the stat which you would like to play in this round: (1 or 2 or 3 or 4)");
        int input1 = sc.nextInt();

        int resultOfRound = LinkedList.compare(hand1, hand2, roundCount, input1);

        System.out.println("The Computer's card for this round is as follows:");
        System.out.println("_________________________________________________");
        LinkedList.printCard(hand2,roundCount);

        System.out.println("_________________________________________________");

        if (resultOfRound == 1) {
            System.out.println("You have won this round");
            player1Score++;
            }
        if (resultOfRound == -1) {
            System.out.println("You have lost this round");
            computerScore++;

            }
        if (resultOfRound == 0) {
            System.out.println("This round was a tie");
            }

        System.out.println("Player1 score: " + player1Score + "    Computer score: " + computerScore);
    }
}