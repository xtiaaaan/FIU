/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysandarraylists;

/**
 *
 * @author KCISCisco
 */
import java.util.ArrayList;
public class ArraysAndArrayLists {
    public static void main(String[] args) {
        int [] favNumbers = new int[5];
        favNumbers[0] = 12;
        favNumbers[1] = 54;
        favNumbers[2] = -1;
        favNumbers[3] = -2;
        favNumbers[4] = -3;
        int [] favNumbers2 = {1,2,3};
        System.out.println(favNumbers2.length);
        String [] favSportsTeams = {"Heat", "Dolphins"
        , "Marlins", "Panthers", "Hurricanes"};
        System.out.println(favSportsTeams[0]);
        for(int i = 0; i < favNumbers.length; i++)
            System.out.println(favNumbers[i]);
        for(String z: favSportsTeams)
            System.out.println(z);
        ArrayList<String> programmingClasses = new
                ArrayList<String>();
        programmingClasses.add("Java");
        programmingClasses.add("C++");
        programmingClasses.add("VB");
        for (String string : programmingClasses) {
            System.out.println(string);
        }
        ArrayList al = new ArrayList();
        al.add(7.4);
        al.add("Hello World");
        al.add(new Object());
        
        ArrayList<Double> d = new ArrayList<Double>();
        d.add(74.3);
        d.add(100.0);
        
        C p = new C(74);
        System.out.println(p.d);
        ArrayList<C> alC = new ArrayList<C>();
        alC.add(p);
        
        C [] arrayOfC = new C[10];
        arrayOfC[0] = p;
        arrayOfC[1] = new C(55); //to make an object!
       //Create a class D with one attribute
       //a String e that can be set with the constructor
       //Make an ArrayList and add three D objects!
    }
}
class C
{
    int d;
    C(int d)
    {
        this.d = d;
    }
    
}