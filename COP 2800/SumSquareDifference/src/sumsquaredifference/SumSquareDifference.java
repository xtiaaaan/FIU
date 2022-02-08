/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumsquaredifference;

/**
 *
 * @author Chris
 */
public class SumSquareDifference {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long sum10 = 0;
        long sumSQ = 0;
        
        for(int i = 1; i <= 100; i++){
            sum10 += i;
            sumSQ += i * i;
        }
        
        sum10 = sum10 * sum10;
        System.out.println(sum10);
        System.out.println(sumSQ);
        
        System.out.println(sum10 - sumSQ);
        
    }
    
}
