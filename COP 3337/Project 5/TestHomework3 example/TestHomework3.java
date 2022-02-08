import java.util.*;
/**
 * tests the Math3, English3, Science3, and Java3 class
 * 
 * 
 * @author C. Walker 
 * @version 2/24/19
 */
public class TestHomework3
{
	
    public static void main(String []args)
    {   
       
        
        ArrayList<Homework3> tester = new ArrayList<Homework3>();
	    
	     tester.add( new Math3());
	     tester.get(0).createAssignment(4);
	     tester.add( new Science3());
	     tester.get(1).createAssignment(6);
	     tester.add( new English3());
        tester.get(2).createAssignment(4);
        tester.add( new Java3());
        tester.get(3).createAssignment(3);

	    for(Homework3 c: tester)
	    {  
           System.out.println(c);
  	    }
       
       System.out.println();
       
       for(int i = 1; i < tester.size(); i++)
       {  	    
  	      if(tester.get(0).compareTo(tester.get(i)) == 0) 
  	         System.out.println("The homework for Math and " + tester.get(i).getTypeHomework() + " are the same number of pages");
         if(tester.get(0).compareTo(tester.get(i)) == -1)
             System.out.println("The number of pages for the Math homework is less than the number of pages for " + tester.get(i).getTypeHomework());
         if(tester.get(0).compareTo(tester.get(i)) == 1)
             System.out.println("The number of pages for the Math homework is greater than the number of pages for " + tester.get(i).getTypeHomework());

       }
  
	}
}