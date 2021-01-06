package com.company;

import java.util.Scanner;
import java.util.Random;

public class Round {

    private static int player1Score;
    private static int computerScore;
    private static int player1Index = 1;
    private static int computerIndex = 1;
    private static int centreCardIndex = 1;
    private static int player1NumCards = 15;
    private static int computerNumCards = 15;
    private static int input1;
    private static boolean gameOver = false;
    private static boolean player1Round = true;
    private static boolean gameEasy = true;

    //Setter for game difficulty level.
    public static void setLevel(boolean input){
        gameEasy = input;
    }

    //Setter for whether player1 or computer picks the next stat.
    public static void setPlayer1Round(boolean input){
        player1Round = input;
    }

    public static boolean gameRound(LinkedList hand1, LinkedList hand2, LinkedList centreCards) {

        gameOver = false;

        //Once a player reaches the end of their linked list this will reset them back to the start.
        if(player1Index> player1NumCards){
            player1Index = 1;
        }
        if(computerIndex>computerNumCards){
            computerIndex = 1;
        }

        //prints out the players card for this round
        System.out.println();
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
        System.out.println();
        System.out.println("The Computer's card for this round is as follows:");
        System.out.println("_________________________________________________");
        LinkedList.printCard(hand2,computerIndex);
        System.out.println("_________________________________________________");

        //This block operates if player 1 wins the round.
        if (resultOfRound == 1) {
            //Declares winner of the round and calls method to copy card to winner and delete card from loser
            System.out.println("You have won this round");
            LinkedList.addAtPosition(hand1,hand2,player1Index,computerIndex);
            LinkedList.deleteAtPosition(hand2,computerIndex);
            //resets the score for player1 and confirms next round they pick.
            player1Score++;
            player1Round = true;
            //moves the counter along so that the right next card shows / also has reset to the start
            player1Index = player1Index + 2;
            if(player1Index> player1NumCards){
                player1Index = 1;
            }
            //resets the number of cards held by each player
            player1NumCards++;
            computerNumCards--;
            //if there are cards in the centre they are allocated to the winner.
                while(centreCardIndex>1) {
                    LinkedList.addAtPosition(hand1,centreCards,player1Index,centreCardIndex);
                    LinkedList.deleteAtPosition(centreCards,centreCardIndex);
                    centreCardIndex--;
                    player1Index++;
                    player1NumCards++;
                }
            }

        //This block operates if the computer wins the round.
        if (resultOfRound == -1) {
            //Declares winner of the round and calls method to copy card to winner and delete card from loser
            System.out.println("You have lost this round");
            LinkedList.addAtPosition(hand2,hand1,computerIndex,player1Index);
            LinkedList.deleteAtPosition(hand1,player1Index);
            //resets the score for computer and confirms next round they pick.
            computerScore++;
            player1Round = false;
            //moves the counter along so that the right next card shows / also has reset to the start
            computerIndex = computerIndex + 2;
            if(computerIndex>computerNumCards){
                computerIndex = 1;
            }
            //resets the number of cards held by each player
            computerNumCards++;
            player1NumCards--;
            //if there are cards in the centre they are allocated to the winner.
                while(centreCardIndex>1){
                    LinkedList.addAtPosition(hand2,centreCards,computerIndex,centreCardIndex);
                    LinkedList.deleteAtPosition(centreCards,centreCardIndex);
                    centreCardIndex--;
                    computerIndex++;
                    computerNumCards++;
                }
            }

        //This block operates if the round is a draw
        if (resultOfRound == 0) {
            //Declares that the round is a draw.
            System.out.println("This round was a tie");
            //Calls method to copy cards into the centre
            LinkedList.addAtPosition(centreCards,hand1,centreCardIndex,player1Index);
            LinkedList.addAtPosition(centreCards,hand2,centreCardIndex,computerIndex);
            centreCardIndex = centreCardIndex + 2;
            //Calls methods to delete the cards from hands of both player1 and the computer.
            LinkedList.deleteAtPosition(hand1,player1Index);
            player1NumCards--;
            LinkedList.deleteAtPosition(hand2,computerIndex);
            computerNumCards--;
            }

        //prints out the number of cards held by each player. Other print statements used for debugging.
        System.out.println("Player1 number of cards: " + player1NumCards + "   Computer number of Cards: " + computerNumCards);
        System.out.println();
        //System.out.println("Player1 score: " + player1Score + "    Computer score: " + computerScore);
        //System.out.println("Player1 index is: " + player1Index + "    Computer index is: " + computerIndex);

        //Prints the winner of the game if either player has zero cards left.
        if(player1NumCards == 0){
            System.out.println("The Computer has won this game!!!");
        }
        if(computerNumCards == 0){
            System.out.println("Player1 has won this game!!!");
        }

        //This will return a boolean to end the game if either player no longer has any cards.
        //It will also reset the scores and counters to zero for the next game.
        if(player1NumCards == 0 || computerNumCards == 0){
            gameOver = true;
            player1Score = 0;
            computerScore = 0;
            player1Index = 1;
            computerIndex = 1;
            player1NumCards = 15;
            computerNumCards = 15;
            centreCardIndex = 1;
        }
        return gameOver;
    }
}