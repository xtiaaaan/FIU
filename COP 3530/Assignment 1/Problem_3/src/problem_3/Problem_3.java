package problem_3;
import java.util.Scanner;
/**************************************************************
 Purpose/Description: <Finds a  number located in an array that are in a 
 strictly increasing sequence followed by the strictly decreasing sequence.>
 Author’s Panther ID: <6272632>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/
public class Problem_3 {
    
    //find the largest nums index
    public static int largest(int array[]){
        
        int left = 0;
        int right = array.length -1;
        
        while(left <= right){
            
            int middle = (left + right )/2;
            
            // if array at middle index is less than the value to the right 
            //AND the array at the middle index is greater than the array to the left
            if((array[middle] < array[middle + 1]) && 
               (array[middle] > array[middle - 1])){
                left = middle + 1;
            // if the array at the middle index is less than the value to the 
            //left AND the array at the middle index is greater than the array 
            //to the right of it 
            }else if((array[middle] < array[middle - 1]) && 
                    ( array[middle] > array[middle + 1])){
                right = middle - 1;
            }else{
                return middle;
            }
        }
        //not found
        return -1;
    }
    
    //Regular binary search.
    public static int regularBinary(int[] nums, int target) {
        int left = 0;
        int right = largest(nums);
        
        while(left <= right){
            int middle = (left + right) / 2;
            
            if(target < nums[middle]){ //target value is smaller than middle so search on the left side
                right = middle -1;
            }else if(target > nums[middle]){ // target value is bigger than the middle so search on the right side 
                left = middle + 1;
            }else{
                return middle;
            } 
        }
        //if item does not exist return -1
        return -1;
    }//End of method. 
    
    //Inverted binary search.
    public static int invertedBinary(int[] nums, int target){
        
        int left = largest(nums) + 1;
        int right = nums.length;
        
        while(left <= right){
            int middle = (left + right) / 2;
            
            if(target > nums[middle]){ //target value is bigger than middle so search on the left side
                right = middle -1;
            }else if(target < nums[middle]){ // target value is smaller than the middle so search on the right side 
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }//End of method.
    
    //Main method
    public static void main(String[] args) {
        
        int A[] = { 1, 3, 4, 5, 7, 14, 11, 7, 2, -4, -8};
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a number.");
        int k = input.nextInt();
        
        if(regularBinary(A,k) != -1){
            System.out.println(k + " is located at the " + regularBinary(A,k) + " index.");
        }else if(regularBinary(A,k) == -1){
            System.out.println("The number you entered is not in the array");
        }else if(invertedBinary(A,k) != -1){
            System.out.println(k + " is located at the " + invertedBinary(A,-8) + " index.");
        }else{
            System.out.println("The number you entered is not in the array.");
        }
         
    }
    
}
