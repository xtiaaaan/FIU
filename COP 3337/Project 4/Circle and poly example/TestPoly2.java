
/**
 * This class uses a main method and a showCenter() method to output the shape and its corresponding center.
 * 
 * @author RS
 * @version 11-24-07
 */
import java.util.*;
public class TestPoly2
{ 
    //main method
    public static void main (String[] args)
    {
        ArrayList<Circle> circle = new ArrayList<Circle>();
        
        circle.add( new Circle(2, 4, 5));
        circle.add( new Cylinder(10, 15, 24, 16));
        circle.add( new Oval(25, 10, 5, 3));
        circle.add( new OvalCylinder(40, 10, 5, 3, 5));
        
        showCenter(circle);
    }  
    
    //Output's each array item and it's corresponding center cooridinates
    static void showCenter(ArrayList<Circle> circle)
    {
        for(Circle x : circle)
        {
            String className = x.getClass().getName();
            
            //takes each element in the arrayList and isolates the circle factors
            Circle y = (Circle)x;
            System.out.println(x.center() + " for the " + className);
        }
    } 
}
