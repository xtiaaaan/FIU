/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vet.office;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KCISCisco
 */

class Dog extends Animal //child class
{

    public Dog(double weight, double age, String nameOfAnimal, double cost) {
        super(weight, age, nameOfAnimal, cost);
    }
    
}
public class Animal extends Object { //parent
    //you don't need to explicitly extend Object  
    //attributes
    double weight;
    double age;
    String nameOfAnimal;
    double cost;

    public Animal(double weight, double age, String nameOfAnimal, double cost) {
        this.weight = weight;
        this.age = age;
        this.nameOfAnimal = nameOfAnimal;
        this.cost = cost;
    }
    
//    public String toString()
//    {
//        return " The animal is " + weight + " pounds. ";
//    }

    @Override
    public String toString() {
        return "Animal{" + "weight=" + weight + ", age=" + age + ", nameOfAnimal=" + nameOfAnimal + ", cost=" + cost + '}';
    }
    
    public static void main(String[] args) {
        Animal a = new Animal(100.0, 3, "Fifi", 500.0);
        if(a.cost>200)
            System.out.println("Man that's expensive.");
        else
            System.out.println("Cheap animal!");
        ArrayList<Animal> allTheAnimals = new ArrayList<Animal>();
        allTheAnimals.add(a);
        boolean addAnimals = true;
        while(addAnimals == true)
        {
            System.out.println("Please enter the information necessary about your "
                + "animal.");
        System.out.println("Please enter the weight:");
        Scanner s = new Scanner(System.in);
        double w = s.nextDouble();
        System.out.println("Please enter the age as a whole number:");
        int age = s.nextInt();
        s.nextLine();
        System.out.println("Please enter the name of the animal:");
        String n = s.nextLine();
        System.out.println("Please enter the cost:");
        double cost = s.nextDouble();
        Animal b = new Animal(w, age, n, cost);
        allTheAnimals.add(b);
            System.out.println("Do you wish to continue type true or false:");
            addAnimals = s.nextBoolean();
        }
        for(Animal aa: allTheAnimals)
        {
            System.out.println(aa);
        }
    }
}
