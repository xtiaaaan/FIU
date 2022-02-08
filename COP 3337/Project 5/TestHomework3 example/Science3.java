
/**
 * myScience3 extends Homework3.
 * 
 * 
 * @author C. Walker 
 * @version 2/24/19
 */
public class Science3 extends Homework3
{
	/**
	 * Constructor for objects of class Science3
	 */
	public Science3()
	{
		super();
	}

	public void createAssignment(int p)
	{
	    setPagesRead(p);
	    setTypeHomework("Science");
	}

	public void doReading()
	{
	    setPagesRead(getPagesRead() - 3);
	}	
}
