package com.company;

import java.util.ArrayList;
import java.util. *;



public class Deck {

    // Creating a String of array to store cards number and shape data
    String[] numberList = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    String[] shapeList = {"Diamonds","Hearts","Clubs","Spades"};

    // Creating a ArrayList "cards" to store the information of, which cards was made
    private ArrayList <Card> cards = new ArrayList<Card>();

    // Using a for loop to loop each cards number and shape data,
    // So that cards can be made one at time in "Card" and
    // Add that card in a ArrayList "cards" to store that card data
    public Deck(){
        for(int i = 0; i < shapeList.length; i++) {
            for(int j=0; j<numberList.length;j++){

                this.cards.add(new Card(shapeList[i],numberList[j]));
            }
        }
        // Shuffling the deck of cards
        Collections.shuffle(cards);

    }


    // Method to display the one card drawn
    public Card getOneCard()
    {
        System.out.println(cards.get(0));
        Card c = cards.get(0);
        cards.remove(0);
        return c;
    }



    //  method to draw a card from a deck
    public Card draw()
    {
        Card c = cards.get(0);
        cards.remove(0);
        return c;

    }




}
