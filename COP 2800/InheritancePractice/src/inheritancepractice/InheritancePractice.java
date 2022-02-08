/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancepractice;

/**
 *
 * @author Chris
 * 
 */
class A{
    private int i;
    A(int i){
        this.i = i;
    }
    
    public int getI(){
        return i;
    }
    
    public void doAThings(){
        System.out.println("A is great!");
    }    
}

class B extends A{
    B(int i){
        super(i); //this sends the data to the super/parent class
    }
    
    public void doBThings(){
        System.out.println("B is so great!"); //we can add on the behaviors that B can do
    }
}

public class InheritancePractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        A a = new A(12);
        B b = new B(13);
        Object [] stuff = new Object[2];
        stuff[0] = a;
        stuff[1] = b;
        A [] a_array = new A[2];
        a_array[0] = a;
        a_array[1] = b;
        a.doAThings();
        b.doAThings();
        b.doBThings();
    }
    
}
