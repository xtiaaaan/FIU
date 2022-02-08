package major;

/**
 * @author Christian Dominic Angus
 * The ComputerScience class is a subclass of the Major class
 */
public class ComputerScience extends Major {
    private String name ;                                                       // Creates a separate String value within this class for student's name
    private String major ;                                                      // Creates a separate String value within this class for student's major
    private double gpa ;                                                        // Creates a separate double value within this class for student's GPA
    
    public ComputerScience(String name, String major, double gpa) {
        super(name, major, gpa) ;
        this.name = name ;
        this.major = major ;
        this.gpa = gpa ;
    }
    
    @Override
    public String toString(){
        String str = "Name: " + name + "\nMajor: " + major + "\nGPA: " + gpa ;
        return str ;
    }
}
