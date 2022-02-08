
/**
 * Cylinder class that extends Circle
 * 
 * C. Walker
 * 2/2/19
 */
public class Cylinder extends Circle
{
	// instance variables 
	private int height;

	/**
	 * Constructor for objects of class Cylinder
	 */
	public Cylinder(int x, int y, int rad, int h)
	{
		super(x, y, rad);
	    // initialise instance variables
		height = h;
	}

	public int getHeight()
	{
		
		return height;
	}
   
   public String toString()
   {
      return "The cylinder has a radius of " + getRadius() + ", a height of " + height + ", and a center point at " + getX() + ", " + getY();
   }
   
   public String genMessage2()
   {
      return "The figure has a radius of " + getRadius() + " and a height of " + height;
   }
   
   public int calcArea()
   {
      return (int)(2 * Math.PI * Math.pow(getRadius(), 2) + height * (2 * Math.PI * getRadius()));
   }
}
