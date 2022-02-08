/**
 * myMath3 extends Homework3.
 * 
 * 
 * @author C. Walker
 * @version 2/24/19
 */
public class Math3 extends Homework3
{
	/**
	 * Constructor for objects of class Math3
	 */
	public Math3()
	{
		super();
	}

	public void createAssignment(int p)
	{
	    setPagesRead(p);
	    setTypeHomework("Math");
	}
	   
	public void doReading()
	{
	    setPagesRead(getPagesRead() - 2);
   }
}
