
/**
 * OvalCylinder class extends Oval.
 * 
 * C. Walker 
 * 2/2/19
 */
public class OvalCylinder extends Oval
{
	// instance variables 
	private int height;

	/**
	 * Constructor for objects of class OvalCylinder
	 */
	public OvalCylinder(int x, int y, int rad1, int rad2, int h)
	{
		super(x, y, rad1, rad2);
	    // initialise instance variables
		height = h;
	}

	
	public int getHeight()
	{
		
		return height;
	}
   
   public String toString()
   {
      return "The oval cylinder has a radius of " + getRadius() + " and " + getRadius2() + ". A center point at " + getX() + ", " + getY() + " and a height of " + height;
   }
   
   public String genMessage2()
   {
      return "The figure has a radius of " + getRadius() + " and " + getRadius2() + " with a height of " + height;
   }
   
   public int calcArea()
   {
      return (int)(2 * (getRadius() * getRadius2() * Math.PI) + 2 * Math.PI * Math.sqrt(((getRadius() * getRadius() + getRadius2() * getRadius2())/2)) * height);
   }
}
