/**Author: Charlyne Walker
   Date: 2/2/19
   Desc: Tester program for Circle, Oval, Cylinder and Oval Cylinder
   **/
   
   public class TestCircle
   {
      public static void main(String [] args)
      {
         Circle circle1 = new Circle(2, 4, 5);
         Oval oval1 = new Oval(10, 15, 24, 16);
         Cylinder cyl1 = new Cylinder(25, 10, 5, 3);
         OvalCylinder ocyl1 = new OvalCylinder(40, 10, 5, 3, 5);
         
         //print radii of the figures
         System.out.println("The circle has a radius of " + circle1.getRadius());
         System.out.println("The oval has a radius of " + oval1.getRadius() + " and a second radius of " + oval1.getRadius2());
         System.out.println("The cylinder has a radius of " + cyl1.getRadius());
         System.out.println("The Oval Cylinder has a radius of " + ocyl1.getRadius() + " and a second radius of " + ocyl1.getRadius2());
         
         System.out.println();
                  
         //overridden toString output
         System.out.println(circle1);
         System.out.println(oval1);
         System.out.println(cyl1);
         System.out.println(ocyl1);
         
         System.out.println();
         
         
         //generic output inherited from Circle
         System.out.println(circle1.genMessage());
         System.out.println(oval1.genMessage());
         System.out.println(cyl1.genMessage());
         System.out.println(ocyl1.genMessage());

         
         System.out.println();
         
         //generic output inherited from Rectangle and Box
         System.out.println(circle1.genMessage2());
         System.out.println(oval1.genMessage2());
         System.out.println(cyl1.genMessage2());
         System.out.println(ocyl1.genMessage2());
         
         System.out.println();
         
         //area output
         System.out.println("The area of the circle is " + circle1.calcArea());
         System.out.println("The area of the oval  is " + oval1.calcArea());
         System.out.println("The area of the cylinder  is " + cyl1.calcArea());
         System.out.println("The area of the oval cylinder  is " + ocyl1.calcArea());
         
        
      
      }
   
   }