package petstore;

/**
 *
 * @author Christian Dominic Angus
 */
public class Bulldog extends Dog {
    private String myBreed ;    // String value of the dog's breed
    private String myEars ;     // String value of the dog's ears
    private String myFur ;      // String value of the dog's fur
    private String mySnout ;    // String value of the dog's snout
    private String myHeight ;   // String value of the dog's height
    
    /**
     * A constructor for the dog class "Bulldog"
     * The constructor also contains attributes from the
     * Super class dog
     */
    public Bulldog() {
        super() ;
        myBreed = "Bulldog" ;
        myEars = "Floppy" ;
        myFur = "Super short" ;
        mySnout = "Short" ;
        myHeight = "Short but wide" ;
    }
    
     /**
     * Gives the String value of the dog's breed
     * @return myBreed
     */
    @Override
    public String getBreed() {
        return myBreed ;
    }
    
    /**
     * Gives the string value of the dog's ears
     * @return myEars
     */
    @Override
    public String getEars() {
        return myEars ; 
    }

    /**
     * Gives the string value of the dog's fur
     * @return myFur
     */
    @Override
    public String getFur() {
        return myFur ;
    }

    /**
     * Gives the string value of the dog's snout
     * @return mySnout
     */
    @Override
    public String getSnout() {
        return mySnout ;
    }

    /**
     * Gives the string value of the dog's height
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
