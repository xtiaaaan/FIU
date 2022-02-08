
/**
 * Demonstration of the merge sort algorithm as well as linear and binary searches
 * 
 * 
 * @author C. Walker
 * @version 12/27/2020
 */
public class TestMovieMerge
{

    public static void printMovies(Movie[] m)
    {
        //System.out.println("Movie list: \n");
         for(int i = 0; i < m.length; i++)
          System.out.println(m[i]);
        
     }
   public static void sortTitles(Movie[] a, int low, int high)
    {
        if ( low == high )
            return;

        int mid = ( low + high ) / 2;

        sortTitles( a, low, mid ); 
        sortTitles( a, mid + 1, high); 

        mergeTitles( a, low, mid, high);
   }    
   public static void sortDirector(Movie[] a, int low, int high)
    {
        if ( low == high )
            return;

        int mid = ( low + high ) / 2;

        sortDirector( a, low, mid ); 
        sortDirector( a, mid + 1, high); 

        mergeDirector( a, low, mid, high);
   }
   public static void sortYears(Movie[] a, int low, int high)
    {
        if ( low == high )
            return;

        int mid = ( low + high ) / 2;

        sortYears( a, low, mid ); 
        sortYears( a, mid + 1, high); 

        mergeYears( a, low, mid, high);
    }
    public static void mergeTitles( Movie[] a, int low, int mid, int high )
    {
        Movie[] temp = new Movie[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while ( i <= mid || j <= high )
        {
            if ( i > mid )
            {
                temp[ n ] = a[ j ];
                j++;
            }
            else if ( j > high )
            {
                temp[ n ] = a[ i ];
                i++;
            }
            else if ( a[ i ].getTitle().compareTo(a[ j ].getTitle()) < 0 )
            {
                temp[ n ] = a[ i ];
                i++;
            }
            else
            {
                temp[ n ] = a[ j ];
                j++;
            }
            n++;
        }

        for ( int k = low ; k <= high ; k++ )
            a[ k ] = temp[ k - low ];

    } // end of merge
    public static void mergeDirector( Movie[] a, int low, int mid, int high )
    {
        Movie[] temp = new Movie[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while ( i <= mid || j <= high )
        {
            if ( i > mid )
            {
                temp[ n ] = a[ j ];
                j++;
            }
            else if ( j > high )
            {
                temp[ n ] = a[ i ];
                i++;
            }
            else if ( a[ i ].getDirector().compareTo(a[ j ].getDirector()) < 0 )
            {
                temp[ n ] = a[ i ];
                i++;
            }
            else
            {
                temp[ n ] = a[ j ];
                j++;
            }
            n++;
        }

        for ( int k = low ; k <= high ; k++ )
            a[ k ] = temp[ k - low ];

    } // end of merge    
    public static void mergeYears( Movie[] a, int low, int mid, int high )
    {
        Movie[] temp = new Movie[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while ( i <= mid || j <= high )
        {
            if ( i > mid )
            {
                temp[ n ] = a[ j ];
                j++;
            }
            else if ( j > high )
            {
                temp[ n ] = a[ i ];
                i++;
            }
            else if ( a[ i ].getYear() > a[ j ].getYear() )
            {
                temp[ n ] = a[ i ];
                i++;
            }
            else
            {
                temp[ n ] = a[ j ];
                j++;
            }
            n++;
        }

        for ( int k = low ; k <= high ; k++ )
            a[ k ] = temp[ k - low ];

    } // end of merge  
    
    
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
        System.out.println("\nSorted by Title - ascending:");
        sortTitles(myMovies, 0, myMovies.length-1);
        printMovies(myMovies);
        System.out.println("\nSorted by Year - descending:");
        sortYears(myMovies, 0, myMovies.length-1);
        printMovies(myMovies);
        System.out.println("\nSorted by Director - ascending:");
        sortDirector(myMovies, 0, myMovies.length-1);
        printMovies(myMovies);   
        
       
    }
}


