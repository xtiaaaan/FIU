/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catapult;

import java.util.ArrayList;

/**
 *
 * @author XTian
 */
public class Catapult {
    private double[][] arr ;                                                    // The 2D array that stores the trajectory values
    private ArrayList<Double> best;                                             // The arraylist that stores the best trajectory values
    private int[] speed ;                                                       // The 1D array that stores the speed values
    private int[] angle ;                                                       // The 1D array that stores the angle values
    private int rows ;                                                          // The int value for rows or how many speed values there are
    private int columns ;                                                       // The int value for columns or how many angle values there are
    private int min ;                                                           // The minimum value for the best trajectory
    private int max ;                                                           // The maximum value for the best trajectory
    private final double gravity = 9.8 ;                                        // The double value of the gravitational constant
    
    /**
     * The constructor for the Catapult Class
     * @param speed the array containing the speed values 
     * @param angle the array containing the angle values
     * @param min the int value of the minimum best trajectory
     * @param max the int value of the maximum best trajectory
     */
    
    public Catapult(int[] speed, int[] angle, int min, int max){
        this.best = new ArrayList<Double>() ;
        this.arr = new double[speed.length][angle.length] ;
        this.rows = speed.length ;
        this.columns = angle.length ;
        this.speed = speed ;
        this.angle = angle ;
        this.min = min ;
        this.max = max ;
        
        for(int i = 0; i < speed.length; i++){
            for(int j = 0; j < angle.length; j++){
                arr[i][j] = ((Math.pow(speed[i], 2))*
                        ((Math.sin(Math.toRadians(angle[j]*2)))))/gravity ;
            }
        }
        
        for(int i = 0; i < speed.length; i++){
            for(int j = 0; j < angle.length; j++){
                if(min <= arr[i][j] && arr[i][j] <= max){
                    best.add(arr[i][j]) ;
                }
            }
        }
    }
    
    /**
     * A function that prints out the trajectory values in a table 
     * and the best values for the trajectory
     */
    public void printOut(){
        System.out.println("            Projectile Table") ;
        System.out.println("----------------------------------------") ;
        
        System.out.print("Speed     ");
        for(int i = 0; i < angle.length; i++){
            System.out.printf("%d", angle[i]) ;
            System.out.printf("%-13s", "deg") ;
        }
        System.out.println();
        
        for(int i = 0; i < speed.length; i++){
            System.out.printf(" %-8d", speed[i]) ;
            for(int j = 0; j < angle.length; j++){
                System.out.printf("%-15.3f", arr[i][j]) ;
            }
            System.out.println();
        }
        System.out.println("\n----------------------------------------");
        System.out.println("Best Trajectory Values:") ;
        
        for(int i = 0; i < best.size(); i++){
            System.out.printf("%.3f  ", best.get(i)) ;
        }
        System.out.println("\n----------------------------------------\n");
    }
}
