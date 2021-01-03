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
    public void insertHead(Card[] cardArray, int a) {
        Link newLink = new Link(cardArray, a);
        newLink.next = first;
        first = newLink;
    }

    //method to delete a card from a particular position - not called yet.
    public static void deleteAtPosition(LinkedList hand, int index) {
        //Store head link
        Link currLink = hand.first, prev = null;

        //Case 1: if index is 0, then head node itself is to be deleted
        if(index == 0 && currLink != null){
            hand.first = currLink.next;
        }

        //Case2: If the index is greater than 0 but less than the size of LinkedList
        int counter = 0;

        while(currLink != null){

            if(counter == index){
                prev.next = currLink.next;
            }
            else {
                prev = currLink;
                currLink = currLink.next;
                counter++;
            }
        }
    }

    //method to call the insert method alternatively on hand1 and hand2.
    public static void deal(LinkedList hand1, LinkedList hand2, Card[] cardArray) {
        int a = 0;
        while (a < cardArray.length) {
            hand1.insertHead(cardArray, a);
            a++;
            hand2.insertHead(cardArray, a);
            a++;
        }
        //System.out.println("Deal Complete."); used only for debugging to identify where errors occur.
    }

    //method to print linked list - not a part of the game software.
    //Used extensively in the build and testing of the software.
    public static void printList(LinkedList list) {
        Link currLink = list.first;
        System.out.print("Linkedlist: ");

        while (currLink != null) {
            System.out.print(currLink.playerName + " ");
            currLink = currLink.next;
        }
        System.out.println();
    }

    //Method used to print the first card in the each players dec
    public static void printCard(LinkedList list, int indexNum) {
        LinkedList.Link currLink = list.first;
        for(int i = 1; i<indexNum; i++) {
            currLink = currLink.next;
        }
        System.out.println("Player Name: " + currLink.playerName);
        System.out.println("Player Country: " + currLink.playerCountry);
        System.out.println("Stat 1 - Shooting: " + currLink.shooting);
        System.out.println("Stat 2 - Passing: " + currLink.passing);
        System.out.println("Stat 3 - Tackling: " + currLink.tackling);
        System.out.println("Stat 4 - Pace: " + currLink.pace);
        System.out.println();
    }

    //Method used to compare a particular in two cards - will return 1, -1 or 0
    public static int compare(LinkedList hand1, LinkedList hand2, int player1Index, int computerIndex, int num) {
        LinkedList.Link curr1Link = hand1.first;
        for(int i = 1; i<player1Index; i++) {
            curr1Link = curr1Link.next;
        }
        LinkedList.Link curr2Link = hand2.first;
        for(int i = 1; i<computerIndex; i++){
            curr2Link = curr2Link.next;
        }
        switch (num) {
            case 1 -> {
                return Integer.compare(curr1Link.shooting, curr2Link.shooting);
            }
            case 2 -> {
                return Integer.compare(curr1Link.passing, curr2Link.passing);
            }
            case 3 -> {
                return Integer.compare(curr1Link.tackling, curr2Link.tackling);
            }
            case 4 -> {
                return Integer.compare(curr1Link.pace, curr2Link.pace);
            }
        }
        return 1000;
    }

    //Method for the computer to check its card to identify which is the highest stat on its card.
    public static int checkCard(LinkedList hand2, int computerIndex){
        LinkedList.Link curr2Link = hand2.first;
        for(int i = 1; i<computerIndex; i++){
            curr2Link = curr2Link.next;
        }
                if((curr2Link.shooting>=curr2Link.passing)
                && (curr2Link.shooting>=curr2Link.tackling)
                && (curr2Link.shooting>=curr2Link.pace)) {
                return 1;
                }

                if((curr2Link.passing>=curr2Link.shooting)
                && (curr2Link.passing>=curr2Link.tackling)
                && (curr2Link.passing>=curr2Link.pace)) {
                return 2;
                }

                if((curr2Link.tackling>=curr2Link.passing)
                && (curr2Link.tackling>=curr2Link.shooting)
                && (curr2Link.tackling>=curr2Link.pace)) {
                return 3;
                }

                if((curr2Link.pace>=curr2Link.passing)
                && (curr2Link.pace>=curr2Link.tackling)
                && (curr2Link.pace>=curr2Link.shooting)) {
                    return 4;
                }
        return 1000;
    }
}