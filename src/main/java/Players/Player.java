package Players;

import Rooms.Room;

import java.util.ArrayList;

public abstract class Player implements IMoves {

    private String name;
    private int healthValue;
    private ArrayList<String> treasure;
    private WeaponType weaponType;
    private DefenseType defenseType;

    public Player(String name, int healthValue, WeaponType weaponType, DefenseType defenseType) {
        this.name = name;
        this.healthValue = healthValue;
        this.treasure = new ArrayList<>();
        this.weaponType = weaponType;
        this.defenseType = defenseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public DefenseType getDefenseType() {
        return defenseType;
    }

    public void setDefenseType(DefenseType defenseType) {
        this.defenseType = defenseType;
    }

    public void addTreasure(String treasure){
        this.treasure.add(treasure);
    }

    public boolean checkDeath(){
        boolean result = false;
        if (this.healthValue <= 0){
            result = true;
        }
        return result;
    }

    public String heal(Players players, String playerName) {
        for (Player player : players.getPlayers()){
            if (playerName.equals(player.getName())){
                player.setHealthValue(player.getHealthValue() + 100);
            }
        }return "Cleric heals " + playerName + " by 100 points";

    }
}
