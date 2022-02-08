/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author XTian
 */
public class Hangman {
    private final String[] wordBank = {"Faceless", "Abyssal", "Magus", "Stroke",// The word bank the game is going to use
                            "Bounty", "Siren", "Templar", "Oracle", "Phantom",
                            "Enchantress", "Assassin", "Wyvern"} ;
    private String[] letters =  {"", "", "", "", "", "", "", "",                // An array to store the users guessed letters 
                                    "", "", "", "", "", "", "", "",
                                    "", "", "", "", "", "", "", "",} ;
    private final Random rng = new Random() ;                                   // The games random number generator
    private int rdm = rng.nextInt(wordBank.length) ;                            // The random number generated to use to pick a word from the bank
    private String wordPicked = wordBank[rdm] ;                                 // The word the user is going to guess
    private int wordlen = wordPicked.length() ;                                 // Length of selected word
    private String[] chopped = new String[wordlen] ;                            // An array for the word selected
    private String[] mask = Arrays.copyOf(chopped, chopped.length) ;            // An array for masking the selected word
    private String masked ;                                                     // The string for the masked word
    private int guesses = 8 ;                                                   // The number of guesses remaining
    private int letCntr = 0 ;                                                   // A counter that counts how many letters the user has guessed
    
    public Hangman() {
        for(int i = 0 ; i < wordlen ; i++) {
            chopped[i] = wordPicked.substring(i,i+1) ;
        }
        
        for(int i = 0 ; i < wordlen ; i++) {
            mask[i] = "*" ;
        }
        
        masked = String.join("", mask) ;
    }
    
    /**
     * Shows if word contains the given input
     * @param input the letter guessed by the user
     * @return masked progress of word
     */
    public String revealWord(String input) {
        for(int i = 0; i < wordlen ; i++) {
            if(chopped[i].toLowerCase().equals(input.toLowerCase())) {
                mask[i] = chopped[i] ;
            }
        }
        masked = String.join("", mask) ;
        
        return masked ;
    }
    
    /**
     * Checks if word contains the given input
     * @param input the letter guessed by the user
     * @return returns a flag value for users input
     */
    public int checkGuess(String input) {
        int flag = 0 ;
        
        for(int i = 0 ; i < wordlen ; i++) {
            if(chopped[i].toLowerCase().equals(input.toLowerCase())) {
                flag++ ;
            }
        }
        
        return flag ;
    }
    
    /**
     * Reduces users remaining guesses if word does contain given input
     * @param input the letter guessed by the user
     */
    public void flagGuess(String input) {
        int flag = 0 ;
        
        for(int i = 0 ; i < wordlen ; i++) {
            if(chopped[i].toLowerCase().equals(input.toLowerCase())) {
                flag++ ;
            }
        }
        
        if(flag < 1){
            guesses-- ;
        }
    }
    
    /**
     * Adds the letter guessed by the user to letters Array
     * @param input the letter guessed by the user
     */
    public void addLetter(String input) {
        letters[letCntr] = input ;
        letCntr++ ;
    }
    
    /**
     * Shows the letters guessed by the user
     * @return a string of all guessed letters by the user
     */
    public String showGuesses() {
        String letGuess = String.join("", letters) ;
        
        return letGuess ;
    }
    
    /**
     * Removes remaining "*" in the masked word
     * @return the unmasked word
     */
    public String unMasked() {
        return masked = wordPicked ;
    }
    
    /**
     * Checks if the word still contains "*"
     * @return boolean value if word is still masked
     */
    public boolean hasMask(){
        return masked.contains("*") ;
    }
    
    /**
     * Shows the word the user has to guess
     * @return string value of the word the user has to guess
     */
    public String getWord() {
        return wordPicked ;
    }
    
    /**
     * Shows the number of guesses remaining
     * @return int value of the remaining guess of the user
     */
    public int getGuesses() {
        return guesses ;
    }
    
    /**
     * Shows the masked word the user has to guess
     * @return string value of the masked word the user has to guess
     */
    public String showProgress() {
        return masked ;
    }
}
