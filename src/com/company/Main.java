//  Crazy Eight  Card Project



package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Let's play crazy eight... there will be two player playing.\n" +
                "Player name 'Jessy' and 'Computer'\n");

        Scanner scanner = new Scanner(System.in);



        // creating a instances for other classes
        Deck totalCards = new Deck();
        Player HumanPlayer = new Player( "Jessy");
        Player ComputerPlayer = new Player("Computer");
        DisCard totalDisCard = new DisCard();



        // filling the two players hand with 7 cards to start the game
        for(int i = 0; i < 7; i++) {
            HumanPlayer.fillHand(totalCards.draw());
            ComputerPlayer.fillHand(totalCards.draw());
        }

        // drawing a first card from a deck for a discard to play the game
        totalDisCard.addDisCardHand(totalCards.draw());


        // Calling a method name "play"
        play(HumanPlayer, ComputerPlayer, totalDisCard, totalCards);

    }

    // play method with 4 parameters
    public static void play(Player humanPlayer, Player computerPlayer, DisCard totalDisCard, Deck totalCards){
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println(humanPlayer.getPlayerName());
            System.out.println("You have card hand of :");
            System.out.println(humanPlayer.hand.cardsInHand);
            System.out.println("\nDiscard is: ");
            totalDisCard.showFirstCard();
            System.out.println("\nWhat you want to do?");

            
            int choicePlayer;
            do {
                System.out.println("1 - Play\n2 - Draw\n3 - Pass?");
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number!");
                    scanner.next(); // this is important!
                }
                choicePlayer = scanner.nextInt();
            } while (choicePlayer <= 0 || choicePlayer > 3);


            if (choicePlayer == 1) {

                int indexHand = humanPlayer.hand.displayHand();
                Card toDiscard = humanPlayer.hand.cardsInHand.get(indexHand);
                totalDisCard.addDisCardHand(toDiscard);
                if(totalDisCard.DisCard.get(0) != toDiscard){
                    play(humanPlayer, computerPlayer, totalDisCard, totalCards);
                }
                humanPlayer.hand.cardsInHand.remove(toDiscard);
                //todo possibility to go back after wrong card is played plus don't discard wrong card

                if(humanPlayer.hand.cardsInHand.size() == 1){
                    System.out.println("Hey computer... just to let you know, I only have one card in my hand!");
                }

                if(humanPlayer.hand.cardsInHand.isEmpty()){
                    System.out.println("Jessy win the game!");
                    break;
                }

            } else if (choicePlayer == 2) {
                humanPlayer.fillHand(totalCards.draw());
            } else {

            }

            int oldSize = computerPlayer.hand.cardsInHand.size();


            System.out.println("Computer is Playing");
            for(Card k :computerPlayer.hand.cardsInHand ) {
                if (k.numberCard == totalDisCard.DisCard.get(0).numberCard) {
                    totalDisCard.addDisCardHand(k);
                    computerPlayer.hand.cardsInHand.remove(k);
                    break;

                } else if (k.shapeCard == totalDisCard.DisCard.get(0).shapeCard) {
                    totalDisCard.addDisCardHand(k);
                    computerPlayer.hand.cardsInHand.remove(k);
                    break;
                }

            }

            if(computerPlayer.hand.cardsInHand.size()== oldSize){
                computerPlayer.fillHand(totalCards.draw());

            }

            if(computerPlayer.hand.cardsInHand.size()== 1){
                System.out.println("Hey Jessy... just to let you know, I only have one card left in my hand!");
            }

            if(computerPlayer.hand.cardsInHand.isEmpty()){
                System.out.println("Computer win the game!");
                break;

            }

            System.out.println("Computer is done \n");

        }
    }
}



