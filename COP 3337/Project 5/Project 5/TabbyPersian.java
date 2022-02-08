package petstore;

/**
 *
 * @author Christian Dominic Angus
 */
public class TabbyPersian extends Persian {
    private String persianType ;    // String value for the animal's subbreed
    
    /**
     * Constructor for the bulldog class "French Bulldog"
     * It contains all of the attributes from the MiniLop super class
     * And it's own subbreed attribute
     */    
    public TabbyPersian(){
        super() ;
        persianType = "Tabby Persian" ;
    }
    
    /**
     * Gives the subbreed of the animal
     * @return persianType
     */    
    public String getSubBreed() {
        return persianType ;
    }
    
    @Override
    public String toString() {
        return "Animal: " + getType() + "\nSound: " + getSound() + "\nDiet: "
                + getFood() + "\nBreed: " + getBreed() + "\nSubbreed: " 
                + getSubBreed() + "\nEars: " + getEars() + "\nFur: " + getFur()
                + "\nSnout: " + getSnout() + "\nSize: " + getHeight() ;
    }
    
}
