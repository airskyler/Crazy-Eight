package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by Jessy on 10/30/2015.
 */
public class DisCard {

    ArrayList<Card> DisCard = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void addDisCardHand(Card card) {
        if (DisCard.isEmpty()){
            card = validateEight(card);
            this.DisCard.add(card);
        }
        else {
            Card onTop = DisCard.get(0);
            if (onTop.numberCard == card.numberCard) {

                card = validateEight(card);
                this.DisCard.add(0, card);



            } else if (onTop.shapeCard == card.shapeCard) {

                this.DisCard.add(0, card);

            } else {
                System.out.println("Can not discard! Has to be either " + onTop.numberCard + " or " + onTop.shapeCard+ "\n");

            }
        }

    }

    public void showFirstCard(){
        System.out.println(DisCard.get(0));
    }

    public ArrayList<Card> toStockPile (){
        ArrayList<Card> stack = new ArrayList<Card>();

        for(int i = DisCard.size() -1; i >= 1; i--) {
            stack.add(DisCard.remove(i));
        }
        return stack;
    }

    private Card validateEight(Card card){
        if (card.numberCard == "8") {
            System.out.println("You have a discard with card number 8 ,\n" +
                    "Please choose the suit of the card, you like to play \n" +
                    "Please enter 'H'... if you like to play suit of Heart \n" +
                    "Please enter 'D'... if you like to play suit of Diamond \n" +
                    "Please enter 'S'... if you like to play suit of Spade \n " +
                    "Please enter 'C'... if you like to play suit of Club \n");

            String chooseShape = scanner.next();

            if (chooseShape.equals("H")) {
                card.shapeCard = "Heart";
            }

            else if (chooseShape.equals("D")) {
                card.shapeCard = "Diamond";
            }

            else if (chooseShape.equals("S")) {
                card.shapeCard = "Spade";
            }

            else if (chooseShape.equals("C")) {
                card.shapeCard = "Club";
            }
            else {
                System.out.println("Please pick a suit of the card you like to play!");
            }

        }
        return card;
    }


}
