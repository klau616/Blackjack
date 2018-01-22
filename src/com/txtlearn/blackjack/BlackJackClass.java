package com.txtlearn.blackjack;

import java.util.Scanner;

public class BlackJackClass {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Blackjack");
		
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		
		Deck playerDeck = new Deck(); //creates player's hand
		Deck dealerDeck = new Deck(); //creates dealer's hand
		
		//can omit later
		boolean flag = true;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Would you like to play? (1) Yes / (2) No ");
		int reply = userInput.nextInt();
		if(reply == 1) {
		while(flag) {
			
			if(flag != true) {
				System.out.println("Game over!!");
				break;
			}
			
			boolean endRound = false;
			
			
			//game starts
			//player's hand
			playerDeck.draw(playingDeck);
			playerDeck.draw(playingDeck);
			
			//dealer's hand
			dealerDeck.draw(playingDeck);
			dealerDeck.draw(playingDeck);
		
			while(true) {
				//display player hand
				System.out.println("Your hand: ");
				System.out.println(playerDeck.toString());
				//UPDATEASDLKNASIOLDNLAKSNDLKASNLKANKLDNASKLNDLKASNDLKASNKLDN
				System.out.println("your hand is valued at: " + playerDeck.cardsValue() +  "\n");
				
				
				//Display Dealer Hand
				System.out.println("Dealer hand: \n" + dealerDeck.getCard(0).toString() + " and [Hidde]");
				
				
				//Player decision
				System.out.println("Would you like to (1) Hit or (2) Stay?");
				int response = userInput.nextInt();
				
				if(response == 1) {
					playerDeck.draw(playingDeck);
					System.out.println("You draw: " + playerDeck.getCard(playerDeck.deckSize() -1 ).toString());
					//if over 21
					if(playerDeck.cardsValue() > 21) {
						System.out.println("Bust. Currently valued at " + playerDeck.cardsValue());
						endRound = true;
						break;
					}
				}
				
				if(response == 2) {
					break;
				}
			}
			
			//Dealer's hand show
			System.out.println("Dealer's hand: " + dealerDeck.toString());
			//compare value
			if((dealerDeck.cardsValue()> playerDeck.cardsValue()) && endRound == false) {
				System.out.println("Dealer Wins");

				endRound = true;		
			}
			
			//dealer condition; if 16, draw. if 17, stand
			while((dealerDeck.cardsValue()< 17) && endRound == false) {
				dealerDeck.draw(playingDeck);
				System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
			}
			
			System.out.println("Dealer's hand is at: " + dealerDeck.cardsValue());
			
			if((dealerDeck.cardsValue() > 21) && endRound == false) {
				System.out.println("Dealer bust! You win.");

				endRound = true;
			}
			
			//push?
			if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("Push");
				endRound = true;
			}
			
			//instant win condition
			
			if((playerDeck.cardsValue()) == 21) {
				System.out.println("You win with 21 on hand! ");

				endRound = true;
			}
			else if((dealerDeck.cardsValue()) == 21) {
				System.out.println("Dealer Wins with 21 on hand! ");
	
				endRound = true;
			}
			
			//if both hit 21
			
			if((playerDeck.cardsValue()) == dealerDeck.cardsValue() && endRound == false) {
				System.out.println("Dealer Wins by default");

				endRound = true;
			}
			
			// determining who wins 
			if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("You Wins!");

				endRound = true;
			}
			
			else if(endRound == false){
				System.out.println("You lose.");

				endRound = true;
			}
			
			//resets the deck
			playerDeck.moveAllToDeck(playingDeck);
			dealerDeck.moveAllToDeck(playingDeck);
			System.out.println("End of hand.");
			break;
		}
	}
		else {
		System.out.println("Goodbye!");
		
		}
	}

}
