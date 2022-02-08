package problem.pkg3c;
import java.util.Arrays;
/**************************************************************
 * Purpose/Description:<Make a replaceKey method under the minHeap class. 
 * The method will replace the first occurrence of oldKeywith the newKey, and 
 * restore the Min-Heapproperty after the change. If the oldKeydoes not exist 
 * in the heap, the method prints an appropriate message and returns without 
 * changing the heap. >
 * Author’s Panther ID:<6272632>
 * Certification:I hereby certify that this work is my own and none of it is 
 * the work of any other person.
 **************************************************************/

class MinHeap{
   
    private int[] heap;

    //Begining of replace key method.
    public void replaceKey(Integer oldKey,Integer newKey){
        
        boolean inside = false;
        
        //Iterates through heap one by one O(n)
        int i;
        for(i = 1; i < heap.length; i++){
            
            //convert heap value into Integer Type
            Integer tempo = (Integer) heap[i];
            
            //check to see if the old key is equal to temp
            if(oldKey.compareTo(tempo) == 0){
                inside = true;
                heap[i] = newKey; //set newKey
                
                if(heap[i/2] > heap[i] && i > 0){ //parent node percolates up
                    percolateUp(i); //assume perlocateUp is there
                }
                else{ //child node percolates down
                    percolateDown(i); 
                }
                break;
            }
        }
        
        //if inside is false then the old key was not found.
        if(inside == false){
            System.out.println("Old key not found.");
        }
        
    }// End  of replace key method.
    
}

public class Problem2C {
    
    public static void main(String[] args){

    }
    
}