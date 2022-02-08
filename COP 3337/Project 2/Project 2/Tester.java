/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Scanner;

/**
 *
 * @author XTian
 */
public class Tester {

    /**
     * A test class for the Hangman file
     */
    public static void main(String[] args) {

        boolean status = true ;
        Scanner scan = new Scanner(System.in) ;
        
        do{
            Hangman hangman = new Hangman() ;                                   // Selects a word from the word bank, masks them and
                                                                                // Display the masked word to the user for them to guess
            System.out.println("Welcome to Hangman!\nWhere my codes are made "
                    + "up and the points don't matter\n\nPlease guess "
                    + "the following word: " + hangman.showProgress() +"\nYou"
                            + " have 8 guesses left.") ;
            
            while(hangman.hasMask()){
                String input = scan.nextLine() ;
                
                if(input.length() > 1) {                                        // If user inputs more than one letter the program
                System.out.println("Please enter only one letter") ;            // Program will ask user to submit only one letter
                input = scan.nextLine() ;
                }
            
                if(hangman.checkGuess(input) == 0) {                            // If the selected word does not contain users input
                    if(!hangman.showGuesses().contains(input)) {                // Program will flag guess and see if the user has
                        hangman.addLetter(input) ;                              // Already guessed that letter. If user has not guessed
                        hangman.flagGuess(input) ;                              // That letter, the program will reduce the remaining
                        System.out.println("The letter does not exist in this " // Number of guesses and add it to the array of letters 
                                + "word") ;                                     // The user has guessed
                        System.out.println("Letters you've guessed: " + 
                                hangman.showGuesses()) ;
                        if(hangman.getGuesses() > 0) {
                            System.out.println("You have " + hangman.getGuesses() 
                                                         + " guesses left.") ;
                        }
                        
                        System.out.println("\n" + hangman.showProgress()) ;
                    }
                    else if(hangman.showGuesses().contains(input)) {
                        System.out.println("You've already guessed this "
                                + "letter.") ;
                        System.out.println(hangman.showGuesses()) ;
                        System.out.println("Letters you've guessed: " 
                                + hangman.showGuesses()) ;
                        System.out.println("\n" + hangman.revealWord(input)) ;
                    }

                    if(hangman.getGuesses() == 0) {                             // If user has no guesses remaining, the program will
                        hangman.unMasked() ;                                    // Reveal the word and end the game
                        System.out.println("You have run out of guesses.\n"
                                + "The word was \"" + hangman.getWord() +"\".\n"
                                        + "Better luck next time!") ;
                    }
                }
                else if(hangman.checkGuess(input) > 0) {                        // If the selected word does contain users input the
                    if(!hangman.showGuesses().contains(input)) {                // Program will see if the user has already guessed the
                        hangman.addLetter(input) ;                              // Letter. If user has not guessed that letter, the 
                        System.out.println("Great! You've guessed " +           // Program will unmasked that letter from the word and
                                hangman.checkGuess(input) + " letters.") ;      // Add the word the the array of letters the user has
                        System.out.println("Letters you've guessed: "           // Guessed
                                + hangman.showGuesses()) ;
                        System.out.println("\n"+ hangman.revealWord(input)) ;
                    }
                    else if(hangman.showGuesses().contains(input)) {
                        System.out.println("You've already guessed this "
                                + "letter") ;
                        System.out.println("\n" + hangman.revealWord(input)) ;
                    }
                    
                    if(!hangman.hasMask() && hangman.getGuesses() > 0) {        // If the user has remaining guesses and has unmasked the
                        System.out.println("\nCongratulations! You won!");      // Word. The program will congratulate the user and end
                    }                                                           // The game
                    
                }
                else{
                    System.out.println("Please enter a letter.");
                }
            }
            
            System.out.println("Do you want to play again?\nEnter:\n0 - "       // If the game has ended the program will as the user if
                        + "YES\n1 - NO") ;                                      // They want to play another game
            int playAgain = scan.nextInt() ;
            if(playAgain == 1) {
                status = false ;
            }
            
        }while(status) ;
        
        System.out.println("Thank you for playing!");
    }
    
}
