/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latticepaths;

import java.math.BigInteger;

/**
 *
 * @author Chris
 */
public class LatticePaths {
    
    public static BigInteger lattice(BigInteger x, BigInteger y){
        return (factorial(x.add(y)) / ((factorial(x) * factorial(y))));
    }
    
    public static BigInteger factorial(BigInteger x){
        if(x.equals(0)){
            return 1;
        }
        return factorial(x.subtract(1)) * x;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BigInteger test = lattice(20, 20);
        System.out.println(test);
    }
    
}
