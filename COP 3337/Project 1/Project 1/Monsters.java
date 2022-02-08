/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster;

import java.util.ArrayList;

/**
 *
 * @author XTian
 */
public class Monsters {
    private ArrayList<Monster> monsters = new ArrayList<>();
    
    /**
     * Creates a new list of 5 monsters
     */
    public Monsters(){
        monsters.add(new Monster("Vampire", "Eastern Europe", "Transylvania",
                5000, 180)) ;
        monsters.add(new Monster("Werewolf", "Ancient Greece and Rome", 
                "Greece", 4000, 190)) ;
        monsters.add(new Monster("Giant", "Greece", "Seattle", 800, 300)) ;
        monsters.add(new Monster("Goblin", "Northwestern Europe", "Sweden",
                600, 120)) ;
        monsters.add(new Monster("Demon", "Christianity", "an unknown location", 
                2000, 0)) ;
    }
    
    /**
     * Selects a monster from the ArrayList
     * @param index selects the monster at the index
     * @return return the monster at the index
     */
    public Monster getMonster(int index){
        return monsters.get(index) ;
    }
}
