/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathpractice;

import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class MathPractice {
    
    public static int a;
    public static int b;
    public static int c;

    public MathPractice(int a, int b, int c) {
        MathPractice.a = a;
        MathPractice.b = b;
        MathPractice.c = c;
    }
    
    public static void possibleTriangle(int a, int b, int c){
        if((a + b) >= c){
            System.out.println("Cannot be a triangle");
        }
        else{
            System.out.println("Can be a triangle");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        
        
        possibleTriangle(scan.nextInt(), scan.nextInt(), scan.nextInt());
        
    }
}
