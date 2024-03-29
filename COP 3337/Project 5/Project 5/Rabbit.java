package petstore;

/**
 *
 * @author Christian Dominic Angus
 */
public abstract class Rabbit implements Mammal, Comparable<Mammal> {
    private String myType ;     // String value of the type of animal
    private String mySound ;    // String value of the sound the animal makes
    private String myFood ;     // String value of the type of food it eats
    
    /**
     * Constructor for the animal class "Rabbit"
     */
    public Rabbit() {
        myType = "Rabbit" ;
        mySound = "Rawr" ;
        myFood = "Herbivore";
    }

    /**
     * Gives the String value of the type of animal
     * @return String value of the type of animal
     */
    public String getType() {
        return myType ;
    }
    
    /**
     * Gives the String value of the sound the animal makes
     * @return String value of the sound the animal makes
     */
    public String getSound() {
        return mySound ;
    }
    
    /**
     * Gives the String value of the food the animal eats
     * @return String value of the food the animal eats
     */
    public String getFood() {
        return myFood ;
    }
    
    /**
     * The abstract methods for the rabbit class
     */
    abstract public String getBreed() ;
    abstract public String getEars() ;
    abstract public String getFur() ;
    abstract public String getSnout() ;
    abstract public String getHeight() ;

}
