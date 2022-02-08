/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbercalculator;

import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class NumberCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        String input = scan.next();
        int number = 0;
        boolean numberCorrect = true;
        try{
            number = Integer.parseInt(input) * 2;
        }
        catch(NumberFormatException nf){
            System.out.println("Your number was not valid.");
            numberCorrect = false;
        }
        if(numberCorrect){
            System.out.println("Your number double = " + number);
        }
    }
}
