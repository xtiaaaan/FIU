/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author XTian
 */
public class Tester {

    /**
     * A test class for the Monster file
     */
    public static void main(String[] args) {
        Monsters monsters = new Monsters() ;
        
        boolean status = true ;
        Scanner scan = new Scanner(System.in) ;
        do{
            System.out.println("There are five monsters on the database:\n"
                    + "0 - Vampire\n" + "1 - Werewolf\n" + "2 - Giant\n"
                    + "4 - Goblin\n" + "5 - Demon\n9 - End\nWhich one would "
                    + "you like to see?\n");
            int monInput = scan.nextInt() ;
            if(monInput >= 5 && monInput != 9){
                System.out.println("Please enter a number between 0 - 4") ;
                monInput = scan.nextInt() ;
            }
            
            if(monInput < 5){
                System.out.println(monsters.getMonster(monInput).toString()) ;
                System.out.println("\nWhat would like to do?\n1 - Change the age"
                +" of the monster\n2 - Change the size of the monster\n");
                int input = scan.nextInt() ;
                if(input == 1){
                System.out.println("What would you like to change it "
                        + "to?\n");
                int newAge = scan.nextInt() ;
                System.out.println("Current: " + 
                        monsters.getMonster(monInput).getAge()+ "\n");
                monsters.getMonster(monInput).setAge(newAge) ;
                System.out.println("Updated: " + 
                        monsters.getMonster(monInput).getAge()+ "\n");
                }
                else if(input == 2){
                    System.out.println("What would you like to change it "
                            + "to?\n");
                    int newSize = scan.nextInt() ;
                    System.out.println("Current: " + 
                            monsters.getMonster(monInput).getSize()+ "\n");
                    monsters.getMonster(monInput).setSize(newSize) ;
                    System.out.println("Updated: " + 
                            monsters.getMonster(monInput).getSize()+ "\n");    
                }
                else{
                    System.out.println("Please enter 1 or 2");
                }

            }
            if(monInput == 9){
                status = false ;
            }
        } while(status) ;
        
        System.out.println("Thank you!");
    }
    
}
