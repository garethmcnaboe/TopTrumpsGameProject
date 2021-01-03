package com.company;

import java.util.Scanner;
import java.util.Random;

public class Round {

    private static int player1Score;
    private static int computerScore;
    private static int player1Index = 1;
    private static int computerIndex = 1;
    private static int player1NumCards = 5;
    private static int computerNumCards = 5;
    private static int input1;
    private static boolean gameOver = false;
    private static boolean player1Round = true;
    private static boolean gameEasy = true;


    //Setter for game difficulty level
    public static void setLevel(boolean input){
        gameEasy = input;
    }

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

        //If Player1 won the last round they are asked to pick the next stat
        if(player1Round) {
            //collects the players selection of which stat they wish to play.
            Scanner sc = new Scanner(System.in);
            String input;
            do {
                System.out.print("Please select the stat which you would like to play in this round: (1 or 2 or 3 or 4): ");
                input = sc.nextLine();
            } while (!((input.equals("1")) || (input.equals("2")) || (input.equals("3")) || (input.equals("4"))));
            input1 = Integer.parseInt(input);
        }

        //If Computer won the last round they get to pick the next stat
        if(!player1Round){

            //Computer selects the highest value stat on its card if game difficulty is set at hard
            if(!gameEasy) {
                input1 = LinkedList.checkCard(hand2, computerIndex);
            }

            //Computer randonly picks the next stat 1 to 4 if the game difficulty is set at easy
            if(gameEasy){
                Random rn = new Random();
                input1 = rn.nextInt(4)+1;
            }
            System.out.println("The Computer has selected Stat " + input1 + " for this round.");
        }

        //Calling method to compare the relevant stat on each players card.
        int resultOfRound = LinkedList.compare(hand1, hand2, player1Index, computerIndex, input1);

        //prints out the computers card for this round.
        System.out.println("The Computer's card for this round is as follows:");
        System.out.println("_________________________________________________");
        LinkedList.printCard(hand2,computerIndex);
        System.out.println("_________________________________________________");

        //Adjusts the scores for each player
        if (resultOfRound == 1) {
            System.out.println("You have won this round");
            player1Score++;
            player1Round = true;
            }
        if (resultOfRound == -1) {
            System.out.println("You have lost this round");
            computerScore++;
            player1Round = false;
            }
        if (resultOfRound == 0) {
            System.out.println("This round was a tie");
            }

        //prints out the scores for each player to the screen
        System.out.println("Player1 score: " + player1Score + "    Computer score: " + computerScore);
        System.out.println();
        System.out.println();

        //moves each player onto their next card at the end of each round.
        player1Index++;
        computerIndex++;

        //This will return a boolean to end the game if either player no longer has any cards.
        //It will also reset the scores and counters to zero for the next game.
        if(player1NumCards == 0 || computerNumCards == 0){
            gameOver = true;
            player1Score = 0;
            computerScore = 0;
            player1Index = 1;
            computerIndex = 1;
            player1NumCards = 5;
            computerNumCards = 5;
        }

        return gameOver;
    }
}