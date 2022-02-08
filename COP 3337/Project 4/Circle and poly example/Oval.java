
/**
 * Oval class extends Circle.
 * 
 * C. Walker
 * 2/2/19
 */
public class Oval extends Circle
{
	// instance variables 
	private int radius2;

	/**
	 * Constructor for objects of class Oval
	 */
	public Oval(int x, int y, int rad1, int rad2)
	{
		super(x, y, rad1);
	    // initialise instance variables
		radius2 = rad2;
	}

	public int getRadius2()
	{
		
		return radius2;
	}
   
   public String toString()
   {
      return "The oval has a radius of " + getRadius() + " and " + radius2 + " and a center point at " + getX() + ", " + getY();
   }
	   
   public String genMessage2()
   {
      return "The figure has a radius of " + getRadius() + " and " + radius2;
   }
   
   public int calcArea()
   {
      return (int)(getRadius() * radius2 * Math.PI);
   }
}
