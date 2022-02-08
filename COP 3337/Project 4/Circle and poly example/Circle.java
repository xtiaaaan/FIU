
/**
 * Circle demo
 * 
 * C Walker
 * 2/2/19
 */
public class Circle
{
	// instance variables 
	private int x;
	private int y;
	private int radius;

	/**
	 * Constructor for objects of class Circle
	 */
	public Circle(int x, int y, int r)
	{
		// initialise instance variables
		this.x = x;
		this.y = y;
		radius = r;
	}

	public int getRadius()
	{
		
		return radius;
	}
   
   public int getX()
   {
      return x;
   }
   
   public int getY()
   {
      return y;
   }
   
   public String toString()
   {
      return "The circle has a radius of " + radius + " and a center point at " + x + ", " + y;
   }
   
   public String genMessage()
   {
      return "The figure has a radius of " + radius;
   }
	   
   public String genMessage2()
   {
      return "The figure has a radius of " + radius + " and a center point at " + x + ", " + y;
   }
   
   public int calcArea()
   {
      return (int)(Math.PI * Math.pow(radius, 2));
   }
   
	public String center()
	{
	     return "The center is at (" + x + "," + y + ")";
	}
}
