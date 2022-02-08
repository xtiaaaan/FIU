package major;

/**
 * @author Christian Dominic Angus
 * The Education class is a subclass of the Major class that contains 2
 * additional attributes (Department and Double Major)
 */
public class Education extends Major {
    private String name ;                                                       // Creates a separate String value within this class for student's name
    private String major ;                                                      // Creates a separate String value within this class for student's major
    private double gpa ;                                                        // Creates a separate double value within this class for student's GPA
    private String department ;                                                 // The String value for the department of the student's major
    private boolean doubleMajor ;                                               // A boolean value of whether the student is a double major or not
    
    public Education(String name, String major, double gpa, String department,
            boolean isDoubleMajor) {
        super(name, major, gpa) ;
        this.name = name ;
        this.major = major ;
        this.gpa = gpa ;
        this.department = department ;
        this.doubleMajor = isDoubleMajor ;
    }
    
    /**
     * Shows the department of the current student's major
     * @return department of the student's major
     */
    public String getDepartment() {
        return department ;
    }
    
    /**
     * Sets the new department of the current student's major
     * @param newDepartment the new department of the student's major
     */
    public void setDepartment(String newDepartment) {
        this.department = newDepartment ;
    }
    
    /**
     * Shows whether the current student is a double major
     * @return boolean value of the student's double major status
     */
    public boolean getDoubleMajor() {
        return doubleMajor ;
    }
    
    /**
     * Sets the boolean value whether the current student is a double major
     * @param newDoubleMajor the boolean value of the student's double major status
     */
    public void setDoubleMajor(boolean newDoubleMajor) {
        this.doubleMajor = newDoubleMajor ;
    }
    
    @Override
    public String toString(){
        String yesNo ;
        
        if(doubleMajor){
            yesNo = "Yes" ;
        }
        else{
            yesNo = "No" ;
        }
        
        String str = "Name: " + name + "\nMajor: " + major +
                "\nDepartment: " + department + "\nGPA: " + gpa +
                "\nDouble Major: " + yesNo ;
        return str ;
    }
}
