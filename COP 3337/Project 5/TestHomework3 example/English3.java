
/**
 * myEnglish3 extends Homework3.
 * 
 * 
 * @author C. Walker 
 * @version 2/24/19
 */
public class English3 extends Homework3
{
	/**
	 * Constructor for objects of class English3
	 */
	public English3()
	{
		super();
	}

	public void createAssignment(int p)
	{
	    setPagesRead(p);
	    setTypeHomework("English");
	}
	   
	public void doReading()
	{
	    setPagesRead(getPagesRead() - 1);
   }	
}
