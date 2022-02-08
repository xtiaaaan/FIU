
/**
 * myJava3 extends Homework3.
 * 
 * 
 * @author C. Walker 
 * @version 2/24/19
 */
public class Java3 extends Homework3
{
	/**
	 * Constructor for objects of class Java3
	 */
	public Java3()
	{
		super();
	}

	public void createAssignment(int p)
	{
	    setPagesRead(p);
	    setTypeHomework("Java");
	}

	public void doReading()
	{
	    setPagesRead(getPagesRead() - 4);
	 }	
}
