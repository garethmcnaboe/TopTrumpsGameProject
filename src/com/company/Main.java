package com.company;

public class Main {

    private static boolean playAnotherGame = true;

    public static void main(String[] args) {

        //calling method to show home screen
        Console.printHomeScreen();

        while(playAnotherGame){
            Console.setLevel();

            //create an array called cardArray of 10 card objects.
            Card[] cardArray = new Card[10];

            //calling method which will create objects which will contain the player card data.
            CardData.createCards(cardArray);

            //calling method to shuffle the deck of cards
            Card.shuffleArray(cardArray);

            //create 2 linked lists to hold the two players hands of cards.
            LinkedList hand1 = new LinkedList();
            LinkedList hand2 = new LinkedList();

            //call method to deal cards into the two linked lists created above.
            LinkedList.deal(hand1, hand2, cardArray);

            //call method to print the linked lists.
            //LinkedList.printList(hand1);
            //LinkedList.printList(hand2);

            //call method to run
            boolean gameOver = false;
            while(!gameOver) {
                gameOver = Round.gameRound(hand1, hand2);
            }

            playAnotherGame = Console.anotherGame();
        }
        Console.end();
    }
}