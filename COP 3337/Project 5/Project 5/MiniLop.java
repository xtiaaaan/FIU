package petstore;

/**
 *
 * @author Christian Dominic Angus
 */
public class MiniLop extends Rabbit {
    private String myBreed ;    // String value of the rabbit's breed
    private String myEars ;     // String value of the rabbit's ears
    private String myFur ;      // String value of the rabbit's fur
    private String mySnout ;    // String value of the rabbit's snout
    private String myHeight ;   // String value of the rabbit's height
    
    /**
     * A constructor for the dog class "Mini Lop"
     * The constructor also contains attributes from the
     * Super class dog
     */
    public MiniLop() {
        super() ;
        myBreed = "MiniLop" ;
        myEars = "Short and Floppy" ;
        myFur = "Fluffy" ;
        mySnout = "Short" ;
        myHeight = "Small" ;
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
