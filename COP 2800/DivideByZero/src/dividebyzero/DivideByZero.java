/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dividebyzero;

import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class DivideByZero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ask a user for a number
        //Ask a user for another number (ints)
        //Try to divide the first number by the second
        //Use a try-catch
        //If there is an exception (dividing by zero)
        //Print the error
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int result = 0;
        try{
            result = n1 / n2;
        }
        catch(ArithmeticException nf){
            System.out.println("ArithmeticException\nYou cannot divide by zero.");
        }
        
        System.out.println(result);
    }
    
}
