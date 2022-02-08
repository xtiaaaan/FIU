
/**
 * Abstract class Homework3 
 * 
 * C. Walker
 * 2/24/19
 */
public abstract class Homework3 implements Processing, Comparable<Homework3>
{
	// instance variables - replace the example below with your own
	 private int pagesRead;
	 private String typeHomework;

    public Homework3() 
    {
        pagesRead = 0;
        typeHomework = "none";
    }
	 public abstract void createAssignment(int p);
	
	 public void setPagesRead(int p)
	 {
	    pagesRead = p;
	 }
	 public int getPagesRead()
	 {
	    return pagesRead;
	 }	
	 public void setTypeHomework(String t)
	 {
	    typeHomework = t;
	 }
	 public String getTypeHomework()
	 {
	    return typeHomework;
	 }
    	   
	 public String toString()
	 {
        return getTypeHomework() + " - must read " + getPagesRead() + " pages.";
	 }
	 public int compareTo(Homework3 obj)
	 {
	     if (pagesRead < obj.pagesRead)
	         return -1;
	     else if (pagesRead == obj.pagesRead)
	         return 0;
	     else 
	         return 1;
    }
	   
}

