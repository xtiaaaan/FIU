
/**
 * Class Movie
 * 
 * ©FLVS 2007
 * @author R. Enger 
 * @version 6/25/2007
 */
public class Movie
{
	// instance variables 
	private int year;
	private String title;
	private String director;

	/**
	 * Constructor for objects of class book
	 */
	Movie(String t, int y, String s)
	{
		// initialise instance variables
		title = t;
		year = y; 
		director = s;
	}
	
	public String getTitle()
	{
	    return title;
	}
	public void setTitle(String t)
	{
	    title = t;
	}
	public String getDirector()
	{
	    return director;
	}
	public void setDirector(String s)
	{
	    director = s;
	}
	public int getYear()
	{
	    return year;
	}
	public void setTitle(int y)
	{
	    year = y;
	}
	public String toString()
	{
	   String m;
	   m = title + ", " + year + ", " + director;
	   return m;
    }
			


}
