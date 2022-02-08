/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pythaogreantriplets;

import static java.lang.Math.sqrt;

/**
 *
 * @author Chris
 */
public class PythaogreanTriplets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (double a = 0; a < 1000; a++){
            for (double b = 0; b < 1000; b++){
                double c = sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                if(a + b + c == 1000){
                    if(a < b && b < c){
                        System.out.println(a);
                        System.out.println(b);
                        System.out.println(c);
                    }
                }
                
            }
            
        }
    }
    
}
