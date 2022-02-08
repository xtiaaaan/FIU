package major;

/**
 * @author Christian Dominic Angus
 * The Main class is the tester class of the Major project
 */
public class Main {
    /**
     * The Main class for the Major file
     */
    public static void main(String[] args) {
        ComputerScience student1 =                                              // Creates the student1 object in
                new ComputerScience("Anthony", "ComSci",3.4) ;                  // in the Computer Science class
        
        Biology student2 =                                                      // Creates the student2 object
                new Biology("Brandon", "Biology", 4.0,                          // in the Biology class with 2 new
                        "Arts & Science", true) ;                               // attributes (department and double major)
        
        Education student3 =                                                    // Creates the student3 object
                new Education("Christian", "Education", 3.7,                    // in the Education class with 2 new
                        "English", false) ;                                     // attributes (department and double major)
        
        System.out.println(student1.toString()) ;                               // Prints out all the information from student1
        System.out.println() ;
        System.out.println(student2.toString()) ;                               // Prints out all the information from student2
        System.out.println() ;
        System.out.println(student3.toString()) ;                               // Prints out all the information from student3
    }
}
