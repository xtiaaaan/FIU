
/**
 * Demonstration of the selection sort algorithm as well as linear and binary searches
 * 
 * @author C. Walker
 * @version 12/27/2020
 */
public class TestMovieInsert
{

public static void printMovies(Movie[] m)
    {
        //System.out.println("Movie list: \n");
         for(int i = 0; i < m.length; i++)
          System.out.println(m[i]);
        
     }
   public static void sortTitles(Movie[] source, int order)
    {
      int i;
      int k;
      int posmax;
      Movie temp;

     if (order == 1)
       { 
           for ( i = source.length - 1 ; i >= 0 ; i-- )
           {
               // find largest element in the i elements
               posmax = 0;
               for ( k = 0 ; k <= i ; k++ )
               {
                   if ( source[ k ].getTitle().compareTo(source[ posmax ].getTitle()) > 0 )
                        posmax = k;
                }
                // swap the largest with the position i
                // now the item is in its proper location 
                temp = source[ i ];
                source[ i ] = source[posmax ];
                source[ posmax ] = temp;
            }
       }
     else if (order == 2)
        {
           for ( i = source.length - 1 ; i >= 0 ; i-- )
           {
               // find largest element in the i elements
               posmax = 0;
               for ( k = 0 ; k <= i ; k++ )
               {
                   if ( source[ k ].getTitle().compareTo(source[ posmax ].getTitle()) < 0 )
                        posmax = k;
                }
                // swap the largest with the position i
                // now the item is in its proper location 
                temp = source[ i ];
                source[ i ] = source[posmax ];
                source[ posmax ] = temp;
            }
        }
   }    
   public static void sortDirector(Movie[] source, int order)
    {
      int i;
      int k;
      int posmax;
      Movie temp;

     if (order == 1)
       { 
           for ( i = source.length - 1 ; i >= 0 ; i-- )
           {
               // find largest element in the i elements
               posmax = 0;
               for ( k = 0 ; k <= i ; k++ )
               {
                   if ( source[ k ].getDirector().compareTo(source[ posmax ].getDirector()) > 0 )
                        posmax = k;
                }
                // swap the largest with the position i
                // now the item is in its proper location 
                temp = source[ i ];
                source[ i ] = source[posmax ];
                source[ posmax ] = temp;
            }
       }
     else if (order == 2)
        {
           for ( i = source.length - 1 ; i >= 0 ; i-- )
           {
               // find largest element in the i elements
               posmax = 0;
               for ( k = 0 ; k <= i ; k++ )
               {
                   if ( source[ k ].getDirector().compareTo(source[ posmax ].getDirector()) < 0 )
                        posmax = k;
                }
                // swap the largest with the position i
                // now the item is in its proper location 
                temp = source[ i ];
                source[ i ] = source[posmax ];
                source[ posmax ] = temp;
            }
        }
   }
   public static void sortYears(Movie[] source, int order)
    {
      int i;
      int k;
      int posmax;
      Movie temp;

     if (order == 1)
       { 
           for ( i = source.length - 1 ; i >= 0 ; i-- )
           {
               // find largest element in the i elements
               posmax = 0;
               for ( k = 0 ; k <= i ; k++ )
               {
                   if ( source[ k ].getYear() > source[ posmax ].getYear() )
                        posmax = k;
                }
                // swap the largest with the position i
                // now the item is in its proper location 
                temp = source[ i ];
                source[ i ] = source[posmax ];
                source[ posmax ] = temp;
            }
       }
     else if (order == 2)
        {
           for ( i = source.length - 1 ; i >= 0 ; i-- )
           {
               // find largest element in the i elements
               posmax = 0;
               for ( k = 0 ; k <= i ; k++ )
               {
                   if ( source[ k ].getYear() < source[ posmax ].getYear() )
                        posmax = k;
                }
                // swap the largest with the position i
                // now the item is in its proper location 
                temp = source[ i ];
                source[ i ] = source[posmax ];
                source[ posmax ] = temp;
            }
        }
    }
    
    public static void linearSearchString(Movie [] source, String target)
    {
     boolean match = false;
     for(int i = 0; i < source.length; i++)
     {
         if(target.equals(source[i].getTitle()))
         {
            System.out.println("The movie is on the list!"); 
            match = true;  
         }
     } 
     if(!match)
         System.out.println("The movie is not on the list!");
    
    }
    
    public static int binarySearchDate(Movie [] source, int date)
    {
          int low = 0;
          int high = source.length - 1;
          
          while (high >= low)
          {
            int mid = (low + high) / 2;
            if (date < source[mid].getYear())
               high = mid - 1;
            else if (date == source[mid].getYear())
               return mid;
            else
               low = mid + 1;
          }
          
            return -1 - low;
    }
   
    
    
    public static void main(String[] args)
    {
        Movie[] myMovies = new Movie[10];
        
        myMovies[0] = new Movie("Captain America: The First Avenger", 2011, "Johnson, Joe");
        myMovies[1] = new Movie("Aquaman", 2018, "Wan, James");       
        myMovies[2] = new Movie("Wonder Woman", 2017, "Jenkins, Patty");
        myMovies[3] = new Movie("Captain America: Civil War", 2016, "Russo, Anthony & Joe");
        myMovies[4] = new Movie("Avengers", 2012, "Whedon, Joss");
        myMovies[5] = new Movie("Star Trek", 2009, "Abrams, JJ");
        myMovies[6] = new Movie("Wonder Woman 1984", 2020, "Jenkins, Patty");
        myMovies[7] = new Movie("Star Trek: Beyond", 2016, "Lin, Justin");
        myMovies[8] = new Movie("Guardians of the Galaxy Vol 2.", 2017, "Gunn, James");        
        myMovies[9] = new Movie("Star Trek: Into Darkness", 2013, "Abrams, JJ");
        
        System.out.println("Before Sorting: ");
        printMovies(myMovies);
        
        System.out.println("\nSorted by Title - descending:");
        sortTitles(myMovies, 2);
        printMovies(myMovies);
        
        System.out.println("\nSorted by Year - descending:");
        sortYears(myMovies, 2);
        printMovies(myMovies);
        
        System.out.println("\nSorted by Director - ascending:");
        sortDirector(myMovies, 1);
        printMovies(myMovies);      
        
                
        //Search examples 
        
        //Check to see if a movie is in the list - linear search
        System.out.println("");        
        System.out.println("Is Star Trek on the list?");
        linearSearchString(myMovies, "Star Trek");
        System.out.println("Is Avengers: Age of Ultron on the list?");
        linearSearchString(myMovies, "Avengers: Age of Ultron");
        
          
        //check to see if a movie is in the list - binary search
        int location = 0;
        myMovies = sortYears(myMovies, 1);
        System.out.println("");
        System.out.println("Is there a move from 2017 on the list?");
        location = binarySearchDate(myMovies, 2017);
        if(location > 0)
            System.out.println("Yes! " + myMovies[location].getTitle() + " was realeased in 2017");
        else
            System.out.println("No, no movie on the list was released in 2017");
            
        System.out.println("");
        System.out.println("Is there a move from 2010 on the list?");
        location = binarySearchDate(myMovies, 2010);
        if(location > 0)
            System.out.println("Yes! " + myMovies[location] + " was realeased in 2010");
        else
            System.out.println("No, no movie on the list was released in 2010");

        
          
    }
    
}

