import java.util.ArrayList;
import java.util.Random;
public class Farm
{
   private ArrayList <Animal> myFarm = new ArrayList <Animal>();
   private Random rand = new Random();

   public Farm()
   {
      myFarm.add(new Cow());
      if(rand.nextInt(2) == 1){
      myFarm.add(new Chick(3));
      }
      else
      myFarm.add(new Chick());
      //myFarm.add(new Chick(1));
      myFarm.add(new Pig());
      myFarm.add(new NamedCow("Elsie"));
   }
   
   public void animalSounds()
   {
      Animal temp;
      /**for (int i = 0; i < myFarm.size(); i++)
      {
         temp = myFarm.get(i);
         System.out.println(temp.getType() + " goes " + temp.getSound());
      }
         NamedCow named = (NamedCow)myFarm.get(3);
         System.out.println(named.getName());
         **/
      
      for(int i = 0; i < myFarm.size(); i++)
      {
      temp = myFarm.get(i);   
      String mac = "Old MacDonald had a farm... ";
      String ei = "ei ei oo";
      String onFarm = "and on that farm he had a ";
      System.out.println(mac);
      System.out.println(ei);
      System.out.print(onFarm); 
      System.out.print(temp.getType());
      System.out.println(" " + ei);
      System.out.println("with a " + temp.getSound()+ " " + temp.getSound() + " here and a " + temp.getSound()+ " " + temp.getSound() + " there.");
      System.out.println(" Here a " + temp.getSound() + " there a " + temp.getSound() + " everywhere a " + temp.getSound() + " " + temp.getSound());
      System.out.println(mac);
      System.out.println(ei);
      System.out.println();
      }
   }}