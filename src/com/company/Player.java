package com.company;

import java.util.ArrayList;

/**
 * Created by Jessy on 10/30/2015.
 */
public class Player {



    //  Creating a instance for the hand class
    Hand hand = new Hand();

    String PlayerName = "";


    // method to get player name
    public String getPlayerName() {
        return PlayerName;
    }


    //  method to set the player name
    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }


    // constructor for the playerName
    public Player(String PlayerName){

        this.PlayerName = PlayerName;

    }





    // method to fill the player hand with card
    public void fillHand(Card card) {
        this.hand.addToHand(card);



    }
}
