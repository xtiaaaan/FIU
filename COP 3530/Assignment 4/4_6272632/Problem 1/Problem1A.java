package problem1a;

import java.util.*;
/*************************************************************
 * Purpose/Description:<Implement (in Java) the radixSort algorithm to sort
 * in increasing order an array of integer positive keys. Make sure each key 
 * is even.>
 * Author’s Panther ID:<6272632>
 * Certification:I hereby certify that this work is my own and none of it 
 * is the work of any other person.
 *************************************************************/
public class Problem1A
{
    public static void main(String[] args){
        
    System.out.println("*** Radix sort in Java ***");

    int[] even = {24, 2, 4, 466, 48, 66, 8, 44};
    int[] odd = {24, 12, 4, 366, 45, 66, 8, 14};
    

    //prints out contents in EVEN array 
    System.out.println("\nBefore Sorting - Even Array");
    System.out.println(Arrays.toString(even));
    radixSort(even);
    
    /**************************************************************************/
    
    //prints out contents in ODD array 
    System.out.println("\n\nBefore Sorting - Odd Array");
    System.out.println(Arrays.toString(odd));
    radixSort(odd);
    }
    
    // A utility function to get maximum value in arr[]
    static int getMax(int array[]){
        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }
    
    //counting sort algo
    static void countingSort(int array[], int exp)
    {
        int output[] = new int[array.length]; // output array
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // occurances
        for (int i = 0; i < array.length; i++){
            count[(array[i] / exp) % 10]++;
        }
 
        // contains position of  digit in output[]
        for (int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
 
        // Build the output array
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
 
        // Copy the output array to the original array, 
        //now the original array contains the sorted nums.
        for (int i = 0; i < array.length; i++){
            array[i] = output[i];
        }
    }
    
    // Main Radix Sort sort function
    public static void radixSort(int array[])
    {
        // Find the maximum number to know number of digits
        boolean odd = false;
 
        //check if its odd
         for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.println("*** Abort *** the input has at least one "
                        + "key with odd digits");
                odd = true;
                 return;
            }
        }
         
        // Using counting sort for every digit in key.
        //tenths is passed where it is the place in the current digit. 
        //ex: 123 , 3 or 1 or 2
        for (int tenths = 1; getMax(array) / tenths > 0; tenths *= 10){
                countingSort(array, tenths);
        }
        
        //if its even it will print out the array after its been sorted
        if(odd == false){
            System.out.println("After Sorting - Even Array");
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i] + ", ");
            }
        }else{//if its odd it will abort
            System.out.println("After Sorting - Even Array");
            System.out.println("*** Abort *** the input has at least one "
                        + "key with odd digits");
        }
    }

}