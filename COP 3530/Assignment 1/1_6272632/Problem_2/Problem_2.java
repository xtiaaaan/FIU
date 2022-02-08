package problem_2;

/**************************************************************
 Purpose/Description: <Implement an efficient (sublinear running time complexity) 
 function in Java to find in A,the numbers of occurrences of the input value k.>
 Author’s Panther ID: <6272632>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/
public class Problem_2 {

    //Start of binary search left most occurance method.
    public static int binLeft(int[] list, int target){
        int left = 0;
        int right = list.length - 1;
        
        while(left < right){
            int middle = left + (right - left) / 2; //instead of (right + left)/2 to prevent overflow
            
            //if the target is greater than the middle of the list we will 
            //equal left to the middle plus 1.
            if(target > list[middle]){
                left = middle + 1; 
            }else{
                right = middle;
            }
        }
        return left;
    }//End of left binary method.

    //Start of binary search right most occurance method.
    public static int binRight(int[] list, int target){
        int left = 0;
        //that the last loop low will equal 6 and last will equal 6 so it 
        //doesnt loop anymore, which is why we take off the -1 for the list.length.
        int right = list.length; 
        
        while(left < right){
            int middle = left + (right - left) / 2;
            
            //if the target is less than the middle of the list we will equal 
            //right to the middle.
            if(target < list[middle]){ 
                right = middle;
            }else{
                left = middle + 1;
            }
        }
        return right - 1;
    }//End of right binary method.

    
    /*Start of method to subtract the last occurance from the first occurance. 
    Then we will use the difference and add 1 to it.
    ex. int A[] = {-1, 2, 3, 5, 6, 6, 6, 6, 10};
    A[7] - A[4] = A[3]
    A[2] + 1 = 4
    6 is repeated 4 times
    */
    public static int occurance(int array[], int num){
        int first = binLeft(array, num);
        int last = binRight(array, num); 
        
        return last - first + 1;
    }//End of duplicate calculator method.
    
    //Main method
    public static void main(String[] args) {
        
        //array that will be used to check for duplicates
        int A[] = {-1, 2, 3, 5, 6, 6, 6, 9, 10};
        
        int find = 6; 
        System.out.println("The number " + find + " is repeated " 
                + occurance(A, find) + " times.");
    }//End of main method.
    
}//End of class.
