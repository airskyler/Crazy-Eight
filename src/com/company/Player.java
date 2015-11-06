package com.company;

import java.util.ArrayList;

/**
 * Created by Jessy on 10/30/2015.
 */
public class Player {



    Hand hand = new Hand();

    String PlayerName = "";


    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }


    public Player(String PlayerName){

        this.PlayerName = PlayerName;

    }





    public void fillHand(Card card) {
        this.hand.addToHand(card);



    }
}
