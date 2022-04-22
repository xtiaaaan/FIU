/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

/**
 *
 * @author XTian
 */
public class Harlequin extends Rabbit {
    private String myBreed ;    // String value of the rabbit's breed
    private String myEars ;     // String value of the rabbit's ears
    private String myFur ;      // String value of the rabbit's fur
    private String mySnout ;    // String value of the rabbit's snout
    private String myHeight ;   // String value of the rabbit's height
    
    /**
     * A constructor for the dog class "Harlequin"
     * The constructor also contains attributes from the
     * Super class dog
     */
    public Harlequin() {
        super() ;
        myBreed = "Harlequin" ;
        myEars = "Long and pointy" ;
        myFur = "Fluffy" ;
        mySnout = "Long" ;
        myHeight = "Big" ;
    }
    
    /**
     * Gives the String value of the rabbit's breed
     * @return myBreed
     */
    @Override
    public String getBreed() {
        return myBreed ;
    }
    
    /**
     * Gives the string value of the rabbit's ears
     * @return myEars
     */
    @Override
    public String getEars() {
        return myEars ; 
    }

    /**
     * Gives the string value of the rabbit's fur
     * @return myFur
     */
    @Override
    public String getFur() {
        return myFur ;
    }

    /**
     * Gives the string value of the rabbit's snout
     * @return mySnout
     */
    @Override
    public String getSnout() {
        return mySnout ;
    }

    /**
     * Gives the string value of the rabbit's height
     * @return myHeight
     */
    @Override
    public String getHeight() {
        return myHeight ; 
    }

    @Override
    public int compareTo(Mammal t) {
        if(getType() == t.getType()) {
            return 0 ;
        }
        else{
            return 1 ;
        }
    }

    @Override
    public String toString() {
        return "Animal: " + getType() + "\nSound: " + getSound() + "\nDiet: "
                + getFood() + "\nBreed: " + getBreed() + "\nEars: " + getEars() 
                + "\nFur: " + getFur() + "\nSnout: " + getSnout() + "\nSize: "
                + getHeight() ;
    }
    
}