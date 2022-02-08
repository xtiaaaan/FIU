/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car.inheritance;

/**
 *
 * @author KCISCisco
 */
public class Car extends Object{
    public static void main(String[] args) {
        Car c; //car reference
        c = new Car("Volvo", 120, 250); //car object
        System.out.println(c.toString());  //calls a method on object
    }
 private String brand;
 private double maxMPH;
 private int horsePower;
//attributes
    public Car(String brand, double maxMPH, int horsePower) {
        this.brand = brand;
        this.maxMPH = maxMPH;
        this.horsePower = horsePower;
    }
    public void carGo(){
        System.out.println("Vrrroom!  Vrrroom!");
    }
//constructor
    @Override
    public String toString() {
        return "Car{" + "brand=" + brand + ", maxMPH=" + maxMPH + ", horsePower=" + horsePower + '}';
    }
 //overridden toString
}
