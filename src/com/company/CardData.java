package com.company;

public class CardData {

    //Method which will create objects which contain the player card data.
    public static void createCards(Card[] cardArray){
        cardArray[0]=new Card("Paul McGrath","Ireland",55,80,75,55);
        cardArray[1]=new Card("Jurgen Klinsmann","West Germany",90,65,55,85);
        cardArray[2]=new Card("Franco Baresi","Italy",50,75,90,65);
        cardArray[3]=new Card("Luis Gabelo Conejo","Costa Rica",75,70,65,80);
        cardArray[4]=new Card("Dragan Stojkovic","Yugoslavia",60,80,75,55);
        cardArray[5]=new Card("Paul Gascogne","England",80,90,40,90);
        cardArray[6]=new Card("Roger Milla","Cameroon",75,85,50,75);
        cardArray[7]=new Card("Diego Maradonna","Argentina",90,85,50,90);
        cardArray[8]=new Card("Salvatore Schillaci","Italy",95,75,55,90);
        cardArray[9]=new Card("Lothar Matthaus","West Germany",65,95,80,65);
    }
}
