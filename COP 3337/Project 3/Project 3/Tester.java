/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catapult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author XTian
 */
public class Tester {
    /**
     * A test class for the Catapult file
     */
    public static void main(String[] args) throws FileNotFoundException {
        File txt = new File("C:\\Users\\nicoa\\Dropbox\\Engineering\\"          // Selects a text file to parse through its data
                + "COP 3337 - Walker\\Project 3\\catapult - test data.txt") ;
        
        Scanner input = new Scanner(txt) ;                                      // Initialize a scanner to parse through the text fiel
        
        int sets = input.nextInt() ;                                            // Selects initial int value on text file as the number of sets in the file
        
        for(int i = 0; i < sets; i++){
            int numSpeed = input.nextInt() ;                                    // Selects next int value as the number of speed elements in the set
            
            int[] speed = new int[numSpeed] ;                                   // Initializes the array to accomodate the amount of speed elements there are in the set
            
            for(int j = 0; j < numSpeed; j++){
                speed[j] = input.nextInt() ;                                    // Selects next n values as the speed elements
            }
            
            int numAngle = input.nextInt() ;                                    // Selects next int value as the number of angle elements in the set
            
            int[] angle = new int[numAngle] ;                                   // Initializes the array to accomodate the amount of angle elements the are in the set
            
            for(int k = 0; k < numAngle; k++){
                angle[k] = input.nextInt() ;                                    // Selects next n values as the angle elements
            }
            
            int min = input.nextInt() ;                                         // Selects the next int values as the minimum value for the best trajectory
            int max = input.nextInt() ;                                         // Selects the next int values as the maximum value for the best trajectory
            
            Catapult item = new Catapult(speed, angle, min, max) ;              // Input parsed data into Catapult Class

            item.printOut() ;                                                   // Prints out every trajectory value of every possible speed and angle of the set
        }                                                                       // as well as the best trajectory values given the minimum and maximum values of the set
    }
    
}
