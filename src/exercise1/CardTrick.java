package exercise1;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;



/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card. 
 * To be used as starting code in Exercise
 *
 * @author dancye
 * @author Paul Bonenfant Jan 25, 2022 
 * @author Aedan Painter October 2026
 */
public class CardTrick {
    
    public static void main(String[] args) {
        //create a hand of 7 cards
        Card[] hand = new Card[7];
        //create random object to generate random values for cards later
        Random r = new Random();
        for (int i = 0; i < hand.length; i++) {
            //set the card value and suit for each card in the deck
            //we do not care about duplicate cards at this point
            //so a simple random call is fine
            Card card = new Card();
            //because this function generates a value to 0 to n-1
            //and I want 1-13
            //I just do 0-12 and add one at the end, easy peasy
            card.setValue(r.nextInt(13)+1);

            card.setSuit(Card.SUITS[r.nextInt(4)]);
            hand[i] = card;
        }

        //create scanner to read user input
        Scanner scanner = new Scanner(System.in);
        //create card object for user
        //the data for this object will be populated later
        Card usrCard = new Card();
        
        //basic while true for rudimentary verification
        cardGuess:
        while(true){
            //prompt user to pick a card, and ask for two values
            System.out.println("Pick a card, any card!");
            System.out.println("ENTER CARD VALUE NOW (1-13)");
            String usrValue = scanner.nextLine();
            System.out.println("ENTER CARD SUIT NOW (Hearts[0], Diamonds[1], Spades[2], Clubs[3])");
            String usrSuit = scanner.nextLine();
            //because the parseInt function can return an exception
            //it is put within a try-catch block
            try{
            int val = Integer.parseInt(usrValue);
            int suitIndex = Integer.parseInt(usrSuit);
            //throw errors for easy card validity checking
            if(val <= 0 || val > 13) throw new Exception("invalid card value");
            if(suitIndex < 0 || suitIndex > 3) throw new Exception("invalid card suit");
            usrCard.setValue(val);
            usrCard.setSuit(Card.SUITS[suitIndex]);
            }
            //though the error handling here could be much more robust,
            //I don't want to make it overkill for the exercise
            //since I'm not supposed to be worrying about duplicate cards
            //I'm sure weird card values should be fine
            catch (Exception e){
                System.out.println("INVALID CARD DETAILS");
            }
            //user feedback to show their guess (this was useful in testing, but I am just
            //keeping it anyway
            System.out.println("You Guessed: "+usrCard.getValue() + ", " + usrCard.getSuit());
            //this verification system I am keeping in the while loop
            //simply because using the break logic makes it a little easier here
            //instead of keeping track with a seperate variable for if a card was found
            //to display the wrong card dialogue
            for(Card c: hand){
                if(c.getValue() == usrCard.getValue() && c.getSuit().equals(usrCard.getSuit())){
                    printInfo();
                    //naming loops allows my to break out of the entire while loop
                    //instead of just the currently encompasing for loop
                    break cardGuess;
                }
            }
            System.out.println("Wrong card! My secrets remain hidden...");
            break;
        
        }
        
    }

    /**
     * A simple method to print out personal information. Follow the instructions to 
     * replace this information with your own.
     * @author Paul Bonenfant Jan 2022
     * @author Aedan Painter October 2026
     */
    private static void printInfo() {
    
        //I'm done!
        
        System.out.println("Congratulations, you guessed right!");
        System.out.println();
        
        System.out.println("My name is Aedan, though people also call me Azy");
        System.out.println();
        
        System.out.println("My (short term) career ambitions:");
        System.out.println("-- Be more active on github");
        System.out.println("-- Get an internship that can act as a stepping stone towards the aerospace industry");
	System.out.println();	

        System.out.println("My hobbies:");
        System.out.println("-- Programming");
        System.out.println("-- Engineering");
        System.out.println("-- Blacksmithing");
        System.out.println("-- Writing");

        System.out.println();
        
    
    }

}
