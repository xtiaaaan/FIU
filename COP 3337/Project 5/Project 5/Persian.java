package petstore;

/**
 *
 * @author Christian Dominic Angus
 */
public class Persian extends Cat {
    private String myBreed ;    // String value of the cat's breed
    private String myEars ;     // String value of the cat's ears
    private String myFur ;      // String value of the cat's fur
    private String mySnout ;    // String value of the cat's snout
    private String myHeight ;   // String value of the cat's height
    
    /**
     * A constructor for the dog class "Persian"
     * The constructor also contains attributes from the
     * Super class dog
     */
    public Persian() {
        super() ;
        myBreed = "Persian" ;
        myEars = "Pointy" ;
        myFur = "Fluffy" ;
        mySnout = "Short" ;
        myHeight = "Short" ;
    }
    
    /**
     * Gives the String value of the cat's breed
     * @return myBreed
     */
    @Override
    public String getBreed() {
        return myBreed ;
    }
    
    /**
     * Gives the string value of the cat's ears
     * @return myEars
     */
    @Override
    public String getEars() {
        return myEars ; 
    }

    /**
     * Gives the string value of the cat's fur
     * @return myFur
     */
    @Override
    public String getFur() {
        return myFur ;
    }

    /**
     * Gives the string value of the cat's snout
     * @return mySnout
     */
    @Override
    public String getSnout() {
        return mySnout ;
    }

    /**
     * Gives the string value of the cat's height
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
