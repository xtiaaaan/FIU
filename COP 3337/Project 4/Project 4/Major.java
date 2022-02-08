package major;

import java.util.ArrayList;

/**
 * @author Christian Dominic Angus
 * The Major class is the super class of the Major project
 */
public class Major {
    private String name ;                                                       // The string for the student's name
    private String major ;                                                      // The string for the student's major
    private ArrayList<String> majorList = new ArrayList<String>() ;             // An array to store all major taken by students
    private double gpa ;                                                        // The double value of the student's GPA
    
    public Major(String name, String major, double gpa) {
        this.name = name ;
        this.gpa = gpa ;
        this.major = major ;
        
        majorList.add(major) ;
    }
    
    /**
     * Shows the name of the current student
     * @return name of the student
     */
    public String getName() {
        return name ;
    }
    
    /**
     * Sets the new name of the current student
     * @param newName the new name of the student
     */
    public void setName(String newName) {
        this.name = newName ;
    }
    
    /**
     * Shows the GPA of the current student
     * @return 
     */
    public double getGPA() {
        return gpa ;
    }
    
    /**
     * Sets the new GPA of the current student
     * @param newGPA the new GPA of the student
     */
    public void setGPA(double newGPA) {
        this.gpa = newGPA ;
    }
    
    /**
     * Shows the major of the current student
     * @return the major of the student
     */
    public String getMajor() {
        return major ;
    }
    
    /**
     * Sets the new major of the current student and adds them to the ArrayList
     * @param newMajor the new major of the student
     */
    public void setMajor(String newMajor) {
        majorList.add(newMajor) ;
        this.major = newMajor ;
    }
    
    @Override
    public String toString(){
        String str = "Name: " + name + "\nGPA: " + gpa ;
        return str ;
    }
}
