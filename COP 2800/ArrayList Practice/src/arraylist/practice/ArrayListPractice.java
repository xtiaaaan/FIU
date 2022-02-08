/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist.practice;

import java.util.ArrayList;

/**
 *
 * @author KCISCisco
 */
public class ArrayListPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> favoriteTeams = new ArrayList<>();
        favoriteTeams.add("Northwestern Bulls");
        favoriteTeams.add("Killian Cougars");
        favoriteTeams.add("Palmetto Panthers");
        for(String team : favoriteTeams){
            System.out.println(team);
        }
    }
}
