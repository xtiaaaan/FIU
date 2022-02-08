package problem.pkg2.pkg1;

import java.util.Stack;

 /**************************************************************
 Purpose/Description: <This program will find an element in an array that 
 appears more than half of the time in that array and display the first index
 of that array if it appears more than half of the time. If it appears less 
 than half of the time it will return -1.>
 Author’s Panther ID: <6272632>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/
public class Problem_2_1 {

    /*Method to find the majority number*/
    static int leader(int[] A){
        
        Stack<Integer> candidate = new Stack<>();
        
        /*Variable to keep track of the frequency of the numbers when 
        traversing through them. */
        int counter = 1; 
        
        //Assume the first element is the leader. PUSH it in the stack
        candidate.push(0); 
        
        for(int i = 1; i < A.length; i++){
            
            /*Increase the counter by 1 if the current leader element is 
            equal to the next, and subtracting if it is not equal. */
            if(A[candidate.peek()] == A[i]){    
                counter++;
            }else{
                counter--;
            }
            
            
            if(counter == 0){
                candidate.pop(); //"pop" off the old candidate
                candidate.push(i); //replace with the new candidate
                counter = 1; //reset counter to 1 
            }
            
        }
        
        //Find the number of times candidate appears in array.
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == A[candidate.peek()]){
                num++;
            }
        }
        
        //Check if candidate actually occurs in more than half of the array.
        if(num > (A.length / 2)){
            return candidate.peek(); //return the first index 
        }else{
            return -1; //return -1 if there is NO leader
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] a = {23, 23, 67, 23, 67, 23, 45}; //====> leader(a) = 0
        
        int[] b = {23, 24, 67, 23, 67, 23, 45}; //====> leader(b) = -1
        
        System.out.println("Leader: " + leader(a));
        System.out.println("Leader: " + leader(b));
        
    }
    
}
