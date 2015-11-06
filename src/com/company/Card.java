package com.company;


// class for making a single card each time it loops
public class Card {

    // initialize the variable
    String shapeCard = "";
    String numberCard = "";



    // using constructor to make the single card
    public Card(String shape, String number){

        this.shapeCard = shape;
        this.numberCard = number;
    }

    // method to make String variable card to help display the card on console
public String toString(){
    return numberCard+ " of "+shapeCard;
}
}
