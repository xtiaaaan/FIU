
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dfreer
 */
public class BabysittingJob {

    String jobID;
    String babySitterName;
    int numChildren;
    int babySitterID;
    int numHours;
    int totalFee;
    
    public BabysittingJob(String jobID, int numChildren, int babySitterID, int numHours) {
        this.jobID = jobID;
        this.numChildren = numChildren;
        this.babySitterID = babySitterID;
        this.numHours = numHours;
    }
    
    public String getbabySitterName(int babySitterID){
        switch(babySitterID){
            case 1:
                babySitterName = "Cindy";
                break;
            case 2:
                babySitterName = "Greg";
                break;
            case 3:
                babySitterName = "Marcia";
                break;
        }
        return babySitterName;
    }
    
    public int getBabySitter(int babySitterID){
        switch(babySitterID){
            case 1:
                totalFee = 8 * numHours * numChildren;
                break;
            case 2:
                totalFee = (10 * numHours) + (4 * numHours * (numChildren - 1));
                break;
            case 3:
                totalFee = (12 * numHours) + (5 * numHours * (numChildren - 1));
                break;
        }
        return totalFee;
    }
    
    public int returnFee(){
      return getBabySitter(babySitterID);
    }
    
    public String toString(){
        return jobID + " " + getbabySitterName(babySitterID) + " $" + getBabySitter(babySitterID);
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BabysittingJob first = new BabysittingJob(s.next(), s.nextInt(), s.nextInt() ,s.nextInt()); 
        System.out.println(first.toString());
        BabysittingJob second = new BabysittingJob(s.next(), s.nextInt(), s.nextInt() ,s.nextInt());
        System.out.println(second.toString());
        BabysittingJob third = new BabysittingJob(s.next(), s.nextInt(), s.nextInt() ,s.nextInt());
        System.out.println(third.toString());
        
    }
}
