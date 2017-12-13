package Rooms;

import Baddies.Monster;

import java.util.ArrayList;

public class Room {

    private ArrayList<Monster> monsters;
    private ArrayList<String> treasure;


    public Room() {
        this.monsters = new ArrayList<>();
        this.treasure = new ArrayList<>();
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void addMonsters(Monster monster) {
        this.monsters.add(monster);
    }

    public ArrayList<String> getTreasure() {
        return treasure;
    }

    public void addTreasure(String treasure) {
        this.treasure.add(treasure);
    }

    public void removeMonster(Monster monster){
        this.monsters.remove(monster);
    }

    public String listAllMonsters(){
        ArrayList<String > list = new ArrayList<>();
        for (Monster monster : monsters){
            list.add(String.format("%s \n", monster.prettyName()));
        }
        String result = String.join("", list);
        return result;
    }
}
