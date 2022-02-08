/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car.inheritance;

public class Corvette extends Car{
    public static void main(String[] args) {
        Corvette c = new Corvette(true, true, "Corvette", 210, 400);
        c.carGo();
        System.out.println(c.toString());
    //ask the user for the information about a corvette...
        //add the corvette object to an arraylist!
    }
    
    @Override
    public void carGo(){
        System.out.println("VRRRRRRRRRRRRRRRRRRROOM!!!! VRRRROM!!!");
    }
    private boolean isConvertible;
    private boolean isManual;
    public Corvette(boolean isConvertible, boolean isManual,
            String brand, double MPH, int hp)
    {
        super(brand, MPH, hp); //sending this info fixes the class!
        this.isConvertible = isConvertible;
        this.isManual = isManual;
    }

    @Override
    public String toString() {
        return "Corvette{" + "isConvertible=" + isConvertible 
                + ", isManual=" + isManual + '}' + super.toString();
    }
    
}
