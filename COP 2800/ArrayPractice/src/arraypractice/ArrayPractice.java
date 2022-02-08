/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraypractice;

import java.util.Scanner;

/**
 *
 * @author KCISCisco
 */
public class ArrayPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String [] favoriteTeams = new String[4];
        favoriteTeams[0] = "Miami Heat";
        favoriteTeams[1] = "Miami Dolphins";
        favoriteTeams[2] = "Florida Gators";
        favoriteTeams[3] = "Panthers";
        
        for(int i = 0; i < favoriteTeams.length; i++){
            System.out.println(favoriteTeams[i]);
        }
        
        for(String team : favoriteTeams){
            System.out.println(team);
        }//does the same as the loop above!
        
        //make an array for your user's four favorite integers.
        //read the integers from the console!
        int [] favoriteNumbers = new int[4];
        Scanner s = new Scanner(System.in);
        for(int i = 0; i < favoriteNumbers.length; i++){
        System.out.println("Enter your favorite number:");
        favoriteNumbers[i] = s.nextInt();
        }
        int sum = 0;
        for (int i : favoriteNumbers) {
            System.out.println("Your favorite number :" + i);
            sum += i;
        }  System.out.println("The sum of the numbers entered : " + sum);
    }
}
