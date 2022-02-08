/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster;

import java.util.ArrayList;

/**
 *
 * @author XTian
 */
public class Monster {
    private String monName ;       // The name of the monster
    private String monOrigin ;     // The origin of the monster
    private String monLocation ;   // The location of the monster
    private int monAge ;           // The age of the monster
    private int monSize ;          // The size of the mosnter
    private ArrayList<Monster> monsters = new ArrayList<>(); 
    
    public Monster(String name, String origin, String location, int age,
            int size){
        monName = name ;
        monOrigin = origin ;
        monLocation = location ;
        monAge = age ;
        monSize = size ;
    }
    
    /**
     * Gets the name of the monsters you've selected
     * @return a string with the name of your current monster
     */
    public String getName(){
        return "Your monster is a " + monName +".";
    }
    
    /**
     * Gets the origin of the monster you've selected
     * @return a string with the origin of your monster
     */
    public String getOrigin(){  
        return "Your monster originated from " + monOrigin + ".";
    }
    
    /**
     * Gets the location of the monster you've selected
     * @return a string with the location of your current monster
     */
    public String getLocation(){
        return "Your monster is located at " + monLocation + "." ;
    }
    
    /**
     * Gets the age of the monster you've selected
     * @return a string with the age of your current monster
     */
    public String getAge(){
        return "Your monster's age is " + monAge + " years old.";
    }
    
    /**
     * Set a new age for the monster you've selected
     * @param newAge new age for your current monster
     */
    public void setAge(int newAge){
        this.monAge = newAge ;
    }
    
    /**
     * Gets the size of the monster you've selected
     * @return a string with the size of your current monster
     */
    public String getSize(){
        return "Your monster's size is " + monSize + " cm." ;
    }
    
    /**
     * Set a new size for the monster you've selected
     * @param newSize  new size for your current monster
     */
    public void setSize(int newSize){
        this.monSize = newSize ;
    }
    
    /**
     * Returns a multiline string of information of your monster
     * @return a multiline String of information of your monster
     */
    public String toString(){
        String monString = "Your monster is a " + monName +".\nYour monster "
                + "originated from " + monOrigin + ".\nYour monster is located "
                + "at " + monLocation + ".\nYour monster's age is " + monAge +
                " years old.\nYour monster's size is " + monSize + " cm." ;
        return monString ;
    }
}
