package com.company;

public class LinkedList {

    private Link first;

    //Linked List Node.
    static class Link {
        String playerName;
        String playerCountry;
        int shooting;
        int passing;
        int tackling;
        int pace;
        Link next;

        //Constructor
        public Link(Card[] cardArray, int a) {
            this.playerName = cardArray[a].getPlayerName();
            this.playerCountry = cardArray[a].getPlayerCountry();
            this.shooting = cardArray[a].getShooting();
            this.passing = cardArray[a].getPassing();
            this.tackling = cardArray[a].getTackling();
            this.pace = cardArray[a].getPace();
            next = null;
        }
    }

    //method to deal card at the head of the linked list.
    public void insertHead(Card[] cardArray, int a){
        Link newLink = new Link(cardArray, a);
        newLink.next = first;
        first = newLink;
    }

    //method to call the insert method alternatively on hand1 and hand2.
    public static void deal(LinkedList hand1, LinkedList hand2, Card[] cardArray){
        int a = 0;
        while (a < cardArray.length){
            hand1.insertHead(cardArray, a);
            a++;
            hand2.insertHead(cardArray, a);
            a++;
        }
        System.out.println("Deal Complete");
    }

    //method to print linked list
    public static void printList(LinkedList list){
        Link currLink = list.first;
        System.out.print("Linkedlist: ");

        while(currLink != null){
            System.out.print(currLink.playerName + " ");
            currLink = currLink.next;
        }
        System.out.println();
    }






}
