/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysandarraylists;

import java.util.ArrayList;

public class Students {
    String id;
    String name;
    double moneyOwed;
    public Students(String id, String name){
        this.id = id;
        this.name = name;
    }
    public Students(){
        name = "John Doe";
        id = "FAKEID";
    }
    public static void main(String[] args) {
        Students s = new Students("123f", "Oscar Grouch");
        ArrayList<Students> al = new ArrayList<Students>();
        al.add(s);
        //Ask the user to create students...keep adding
        //them until the user wishes to quit!
        //Add the student objects to the ArrayList
    }
    public String warnStudent(double moneyOwed)
    {
        this.moneyOwed = moneyOwed;
        if(moneyOwed > 0)
            return "Pay up, deadbeat!";
        else
            return "Thank you student.";
    }
    
    
}
