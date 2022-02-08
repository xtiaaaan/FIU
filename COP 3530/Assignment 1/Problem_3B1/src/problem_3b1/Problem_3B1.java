package problem_3b1;

/**************************************************************
 Purpose/Description: < Implement a sublinear running time complexity recursive 
 function: public static long exponentiation(long x, int n) to calculate x^n>
 Author’s Panther ID: <6272632>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/
public class Problem_3B1 {

    public static long exponentiation(long x, int n){ // x^n
        //If the exponent is 0, anything to the 0 power 1.
        if(n == 0){
            return 1;
        }
        
        //If the exponent is 1, anything to the 1 power is itself.
        if(n == 1){
            return x;
        }
        
        //If the exponent is odd,
        if(n % 2 != 0){
            //Recursion  
            return exponentiation((x * x),(n / 2)) * x;
            
        //If the exponent is even.
        }else{
            //Recursion
            return exponentiation((x * x), (n / 2));
        }
    }
    
    public static void main(String[] args) {
        int x = 2; //base
        int y = 2; //exponent/base
        
        System.out.println(exponentiation(x, y));
    }
    
}
