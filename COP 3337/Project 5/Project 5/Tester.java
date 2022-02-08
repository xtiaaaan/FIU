package petstore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Christian Dominic Angus
 */
public class Tester {
    public static void main(String[] args) {
        ArrayList<Mammal> petStore = new ArrayList<Mammal>() ;
            // An ArrayList to store all the animals in the pet store

        /**
         * Creates and stores the listed animals 
         * into the petStore ArrayList
         */
        petStore.add(new Bulldog()) ;       
        petStore.add(new BostonTerrier()) ;
        petStore.add(new GermanShepherd()) ;
        petStore.add(new FrenchBulldog()) ; 
        petStore.add(new Persian()) ;   
        petStore.add(new Siamese()) ;   
        petStore.add(new Sphynx()) ;    
        petStore.add(new TabbyPersian()) ;
        petStore.add(new MiniLop()) ;
        petStore.add(new Dutch()) ;
        petStore.add(new Harlequin()) ;
        petStore.add(new Chinchilla()) ;
        
        Scanner sc = new Scanner(System.in) ;
        
        System.out.println("Welcome to the Pet Store!\nIf you'd like to"
                + " see what pets we have press\n1 for Dogs\n2 for Cats\n3"
                + " for Rabbit\n0 to exit the store");
        
        int input = sc.nextInt() ;
        
        do {
            if(input > 3) {
                System.out.println("Please select an option.");
                input = sc.nextInt() ;
            } else {
                for(int i = 0 ; i < petStore.size() ; i++) {
                    if(input == 1 && 
                            petStore.get(i).getType().compareTo("Dog") == 0) {
                        System.out.println(petStore.get(i).toString() + "\n") ;
                    }
                    if(input == 2 && 
                            petStore.get(i).getType().compareTo("Cat") == 0) {
                        System.out.println(petStore.get(i).toString() + "\n") ;
                    }
                    if(input == 3 &&
                            petStore.get(i).getType().compareTo("Rabbit") == 0) {
                        System.out.println(petStore.get(i).toString() + "\n") ;
                    }
                }
                input = sc.nextInt() ;
            }
            
        } while(input != 0) ;
    }
        
}
