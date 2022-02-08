/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Chris
 */
public class Fibonacci {
    
    public long fibonacci(long n){
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        System.out.println(new Fibonacci().fibonacci(50));
        long endTime = System.currentTimeMillis();
        System.out.println("Execution took " + (endTime - beginTime) / 1000.0 + "seconds");
    }
    
}
