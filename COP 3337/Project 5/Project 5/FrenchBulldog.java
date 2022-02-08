package petstore;

/**
 *
 * @author Christian Dominic Angus
 */
public class FrenchBulldog extends Bulldog {
    private String bulldogType ;    // String value for the animal's subbreed
    
    /**
     * Constructor for the bulldog class "French Bulldog"
     * It contains all of the attributes from the MiniLop super class
     * And it's own subbreed attribute
     */
    public FrenchBulldog(){
        super() ;
        bulldogType = "French Bulldog" ;
    }
    
    /**
     * Gives the subbreed of the animal
     * @return bulldogType
     */
    public String getSubBreed() {
        return bulldogType ;
    }
    
    @Override
    public String toString() {
        return "Animal: " + getType() + "\nSound: " + getSound() + "\nDiet: "
                + getFood() + "\nBreed: " + getBreed() + "\nSubbreed: " 
                + getSubBreed() + "\nEars: " + getEars() + "\nFur: " + getFur()
                + "\nSnout: " + getSnout() + "\nSize: " + getHeight() ;
    }
    
}
