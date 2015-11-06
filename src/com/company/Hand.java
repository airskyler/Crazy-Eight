package com.company;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Jessy on 10/30/2015.
 */
public class Hand {

    ArrayList<Card> cardsInHand = new ArrayList<Card>();



    public void addToHand(Card card){
        this.cardsInHand.add(card);
    }

    public int displayHand() {


        while (true) {

            int handCounter = 0;

            Scanner scanner = new Scanner(System.in);


            //Todo: add validation so that choice can't return number bigger than index
            for (Card j : cardsInHand) {

                System.out.println(String.format("(Enter %d) --> %s", handCounter + 1, j.toString()));
                handCounter++;
            }

            System.out.println("Which card will you like to play from your hand? \n" +
                    "Please enter the number for the card you like to play.");
            int choice = scanner.nextInt() - 1;

            if (choice < cardsInHand.size() && choice >= 0) {


                return choice;
            }

            else
            {
                System.out.println("Entry Error...   please choose your choice for your discard card again!\n");
            }


        }
    }






    public Card discard (int x){

        Card toDiscard = cardsInHand.get(x);
        cardsInHand.remove(x);

        return toDiscard;
    }
}

//
// DisCard.add(Hand.discard())