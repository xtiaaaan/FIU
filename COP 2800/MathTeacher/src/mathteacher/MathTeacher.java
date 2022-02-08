/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathteacher;

import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class MathTeacher {

    public static int n1;
    public static int n2;
    public static int choice;
    public static int result;

    public MathTeacher(int n1, int n2, int choice) {
        MathTeacher.n1 = n1;
        MathTeacher.n2 = n2;
        MathTeacher.choice = choice;
    }
    
    public static int getMethod(int choice){
        switch(choice){
            case 1:
                return addNumbers(n1, n2);
            case 2:
                return subtractNumbers(n1, n2);
            case 3:
                return multiplyNumbers(n1, n2);
            case 4:
                return divideNumbers(n1, n2);
        }
        return 0;
    }

    
    public static int addNumbers(int n1, int n2){
        result = n1 + n2;
        return result;
    }
    
    public static int subtractNumbers(int n1, int n2){
        result = n1 - n2;
        return result;
    }
    
    public static int multiplyNumbers(int n1, int n2){
        result = n1 * n2;
        return result;
    }
    
    public static int divideNumbers(int n1, int n2){
        result = n1 / n2;
        return result;
    }
    
    public static void showText(){
        System.out.println(getMethod(choice));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean t = true;
        
        
        do{
            System.out.println("Welcome to *Mental Math Practice* where you can test your addition, subtraction, multiplication, and division.");	
            System.out.println("Enter two integers: ");
            while(!scan.hasNextInt()){
                scan.nextLine();
            }
            int m1 = scan.nextInt();
            int m2 = scan.nextInt();
            
            System.out.println("Enter 1 to add the two numbers.");
            System.out.println("Enter 2 to subtract the second number from the first number.");
            System.out.println("Enter 3 to multiply the two numbers.");
            System.out.println("Enter 4 to divide the first number by the second number.");
            int option = scan.nextInt();
            MathTeacher m = new MathTeacher(m1, m2, option);
            m.showText();
            
            System.out.println("Enter 'Quit' to end the program.");
            scan.nextLine();
            String quit = scan.nextLine();
            if(quit.equals("Quit")){
                t = false;
            }
        }
        while(t);

        
    }
    
}
