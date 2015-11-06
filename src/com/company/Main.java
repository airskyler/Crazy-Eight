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


            // Given a user a choice to Play, Draw and Pass for the hand
            // With validation for the user entry
            int choicePlayer;
            do {
                System.out.println("1 - Play\n2 - Draw\n3 - Pass?");
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number!");
                    scanner.next();
                }
                choicePlayer = scanner.nextInt();
            } while (choicePlayer <= 0 || choicePlayer > 3);


            // If user choose to play, it will display hand for the users card,
            //  Use will have a choice to pick a card to discard from the hand
            //  And add the user discard card to the discard pile

            if (choicePlayer == 1) {

                int indexHand = humanPlayer.hand.displayHand();
                Card toDiscard = humanPlayer.hand.cardsInHand.get(indexHand);
                totalDisCard.addDisCardHand(toDiscard);
                if(totalDisCard.DisCard.get(0) != toDiscard){
                    play(humanPlayer, computerPlayer, totalDisCard, totalCards);
                }
                humanPlayer.hand.cardsInHand.remove(toDiscard);


                // If the user only have one card for hand, it will let computer know that user only have one card left
                if(humanPlayer.hand.cardsInHand.size() == 1){
                    System.out.println("Hey computer... just to let you know, I only have one card in my hand!");
                }

                // If user has no card in hand, it wins the game
                if(humanPlayer.hand.cardsInHand.isEmpty()){
                    System.out.println("Jessy win the game!");
                    break;
                }


                //  If the user choose to draw
                // it will draw a card from the deck and add that card to the user hand
            } else if (choicePlayer == 2) {
                humanPlayer.fillHand(totalCards.draw());
            } else {

            }

            // making a variable for how many cards of hand the computer have at the moment
            int oldSize = computerPlayer.hand.cardsInHand.size();


            // telling a computer to discard the hand, if the computer have a hands that
            // match a discard card's number or suit
            // If the computer has a hand to discard, it will add that card to the discard pile
            //  and remove that card from a computer hand
            System.out.println("Computer is Playing");
            for(Card k :computerPlayer.hand.cardsInHand ) {
                if (k.numberCard.equals(totalDisCard.DisCard.get(0).numberCard)) {
                    totalDisCard.addDisCardHand(k);
                    computerPlayer.hand.cardsInHand.remove(k);
                    break;

                } else if (k.shapeCard.equals(totalDisCard.DisCard.get(0).shapeCard)) {
                    totalDisCard.addDisCardHand(k);
                    computerPlayer.hand.cardsInHand.remove(k);
                    break;
                }

            }

            // If the computer didn't discard the hand, computer will draw a card from the deck and add that
            //  card to computer's hand
            if(computerPlayer.hand.cardsInHand.size()== oldSize){
                computerPlayer.fillHand(totalCards.draw());

            }

            //  If computer only has one card left in hand. It will display the message that computer has only
            //  one card left
            if(computerPlayer.hand.cardsInHand.size()== 1){
                System.out.println("Hey Jessy... just to let you know, I only have one card left in my hand!");
            }

            //  If computer's hand is empty...  computer win the game
            if(computerPlayer.hand.cardsInHand.isEmpty()){
                System.out.println("Computer win the game!");
                break;

            }

            System.out.println("Computer is done \n");

        }
    }
}



