/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vetapplication;

import java.util.Scanner;

/**
 *
 * @author KCISCisco
 */
public class Dog {
    //attributes...states
    private String breed;
    private double weight;
    private String gender;
    private boolean neutered;
    private String typeOfHair;

    @Override
    public String toString() {
        return "Dog{" + "breed=" + breed + ", weight=" + weight + ", gender=" + gender + ", neutered=" + neutered + ", typeOfHair=" + typeOfHair + '}';
    }
    public static void main(String[] args) {
        //psvm + tab
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the breed:");
        String userBreed = s.nextLine();  //breeds can have more than one string
        System.out.println("Enter the dog's weight in pounds:");
        double userWeight = s.nextDouble();
        System.out.println("Enter the gender:");
        String userGender = s.next();
        System.out.println("Enter true if the dog is neutered/spayed:");
        boolean userNeutered = s.nextBoolean();
        System.out.println("Enter the type of hair (short/medium/long):");
        String userHair = s.next();
        Dog userDog = new Dog(userBreed, userWeight, userGender, userNeutered, userHair);
        userDog.bark();
        Dog myDog = new Dog(
                "Mutt", 45, "female", true, "medium");
        myDog.bark();  System.out.println(myDog);
        int myFirstArray [] = new int[10];
        myFirstArray[0] = 119;
        System.out.println(myFirstArray[0]);
        Dog [] allTheDogs = new Dog[5];
        allTheDogs[0] = myDog;
        allTheDogs[1] = userDog;
        allTheDogs[2] = new Dog("German Shepherd", 100, "male", false, "long");
        for(int i = 0; i < allTheDogs.length; i++)
            System.out.println(allTheDogs[i]);
        for (Dog dog : allTheDogs) {
            System.out.println(dog);
        }
        System.out.println(userDog);
        //ask the user for the data about THEIR DOG
        //and make a dog object based on their data
        
    }
    //for Netbeans to add the constructor...alt+insert
    public Dog(String breed, double weight, String gender, boolean neutered, String typeOfHair) {
        this.breed = breed;
        this.weight = weight;
        this.gender = gender;
        this.neutered = neutered;
        this.typeOfHair = typeOfHair;
    }
    //methods 
    public void bark(){
        System.out.println("Bark bark!");
    }
    
    public void aggress(){
        System.out.println("Snarl and bare teeth!");
    }
    
}
