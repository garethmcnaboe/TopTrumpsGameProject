package com.company;

import java.util.Scanner;

public class Round {

    private static int player1Score;
    private static int computerScore;
    private static int player1Index = 1;
    private static int computerIndex = 1;
    private static int player1NumCards = 5;
    private static int computerNumCards = 5;
    private static boolean gameOver = false;

    public static boolean gameRound(LinkedList hand1, LinkedList hand2) {

        //Once a player reaches the end of their linked list this will reset them back to the start.
        if(player1Index> player1NumCards){
            player1Index = 1;
        }
        if(computerIndex>computerNumCards){
            computerIndex = 1;
        }

        //prints out the players card for this round
        System.out.println("Player 1 card for this round is as follows:");
        System.out.println("___________________________________________");
        LinkedList.printCard(hand1,player1Index);

        //collects the players selection of which stat they wish to play.
        Scanner sc = new Scanner(System.in);
        String input;
            do {
                System.out.print("Please select the stat which you would like to play in this round: (1 or 2 or 3 or 4): ");
                input = sc.nextLine();
            } while (!((input.equals("1"))||(input.equals("2"))||(input.equals("3"))||(input.equals("4"))));
        int input1 = Integer.parseInt(input);


        //calling method to compare the relevant stat on each players card.
        int resultOfRound = LinkedList.compare(hand1, hand2, player1Index, computerIndex, input1);

        //prints out the computers card for this round.
        System.out.println("The Computer's card for this round is as follows:");
        System.out.println("_________________________________________________");
        LinkedList.printCard(hand2,computerIndex);
        System.out.println("_________________________________________________");

        //adjusts the scores for each player
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

        //prints out the scores for each player to the screen
        System.out.println("Player1 score: " + player1Score + "    Computer score: " + computerScore);

        //moves each player onto their next card at the end of each round.
        player1Index++;
        computerIndex++;

        //This will return a boolean to end the game if either player no longer has any cards.
        if(player1NumCards == 0 || computerNumCards == 0){
            gameOver = true;
            return gameOver;
        }
        return gameOver;
    }

}