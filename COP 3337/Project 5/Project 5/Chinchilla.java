package petstore;

/**
 *
 * @author Christian Dominic Angus
 */
public class Chinchilla extends MiniLop {
    private String lopType ;    // String value for the animal's subbreed
    
    /**
     * Constructor for the minilop class "Chinchilla"
     * It contains all of the attributes from the MiniLop super class
     * And it's own subbreed attribute
     */
    public Chinchilla(){
        super() ;
        lopType = "Chinchilla" ;
    }
    
    /**
     * Gives the subbreed of the animal
     * @return lopType
     */
    public String getSubBreed() {
        return lopType ;
    }
    
    @Override
    public String toString() {
        return "Animal: " + getType() + "\nSound: " + getSound() + "\nDiet: "
                + getFood() + "\nBreed: " + getBreed() + "\nSubbreed: " 
                + getSubBreed() + "\nEars: " + getEars() + "\nFur: " + getFur()
                + "\nSnout: " + getSnout() + "\nSize: " + getHeight() ;
    }
    
}
