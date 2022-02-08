package sortingandsearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Christian Dominic Angus
 */
public class SortingAndSearching {

    /**
     * @param args the command line arguments
     */
    public static void printOut(String[][] array) {
        for(int i = 0; i < array.length; i++) {
                for(int j = 0; j < array[i].length; j++) {
                    System.out.printf("%-24s", array[i][j] + "     ") ;
                }
                System.out.println() ;
            }
    }
    
    public static String[][] titleInSort(String[][] array, int order) {
//        int row = array.length ;
//        int column = array[0].length ;
        
        String[][] sorted = array ;
        
        if(order == 1){
            for(int i = 1; i < array.length; i++){
                String next = array[i][0] ;
                int insertindex = 0 ;
                int k = i ;
                while(k > 1 && insertindex == 0) {
                    if(next.compareTo(sorted[k-1][0]) > 0) {
                        insertindex = k ;
                    }
                    else {
                        sorted[k][0] = sorted[k-1][0] ;
                    }
                    k-- ;
                }
                sorted[insertindex][0] = next ;
            }
        }
        else if(order == 2) {
            for(int i = 1; i < array.length; i++) {
                String next = array[i][0] ;
                int insertindex = 0 ;
                int k = i ;
                while(k > 1 && insertindex == 0) {
                    if(next.compareTo(sorted[k-1][0]) < 0) {
                        insertindex = k ;
                    }
                    else {
                        sorted[k][0] = sorted[k-1][0] ;
                    }
                    k-- ;
                }
                sorted[insertindex][0] = next ;
            }
        }
        return sorted ;
    }
    
//    public static void mergeTitle(String[][] array, int low, int mid, int high) {
//        int row = array.length ;
//        int column = array[0].length ;
//        
//        String[][] temp = new String[row][column] ;
//        
//        int i = low , j = mid + 1 , n = 0 ;
//        
//        while(i <= mid || j <= high) {
//            if(i > mid) {
//                temp[n][0] = array[j][0] ;
//                j++ ;
//            }
//            else if(j > high) {
//                temp[n][0] = array[i][0] ;
//                i++ ;
//             }
//            else if(array[i][0].compareTo(array[j][0]) < 0) {
//                temp[n][0] = array[i][0] ;
//                i++ ;
//            }
//            else {
//                temp[n][0] = array[j][0] ;
//                j++ ;
//            }
//            n++ ;
//        }
//        
//        for(int k = low ; k <= high; k++) {
//            array[k][0] = temp[k - low][0] ;
//        }
//    }
    
    public static void main(String[] args) {
        try {
            File TVShow = new File("tv_shows.csv") ;
            Scanner reader = new Scanner(TVShow) ;
            
            List<String[]> lines = new ArrayList<String[]>() ;
            
            while(reader.hasNextLine()) {
                lines.add(reader.nextLine().split(",")) ;
            }
            
            String[][] array = new String[lines.size()][8] ;
            lines.toArray(array) ;
            
            System.out.println("Before Sorting: ") ;
            printOut(array) ;
            
            System.out.println("\nTitle Insertion Sort:");
            titleInSort(array, 1) ;
            printOut(array) ;
            
            reader.close() ; 
        } catch(FileNotFoundException e) {
            System.out.println("An error occurred.") ;
            e.printStackTrace() ;
        }
    }
    
}
