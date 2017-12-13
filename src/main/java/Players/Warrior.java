package Players;

import Baddies.Monster;
import Rooms.Room;

public class Warrior extends Player implements IMoves{
    public Warrior(String name, int healthValue, WeaponType weaponType, DefenseType defenseType) {
        super(name, healthValue, weaponType, defenseType);
    }


    public String attack(WeaponType weapon, String monsterName, Room room) {
        String result = new String();
        for (int i = 0; i < room.getMonsters().size(); i++){
            if (monsterName == room.getMonsters().get(i).getName()){
                    int postAttack = room.getMonsters().get(i).getHealthValue() - this.getWeaponType().attackValue;
                room.getMonsters().get(i).setHealthValue(postAttack);
                    if(room.getMonsters().get(i).getHealthValue() <= 0){
                        room.removeMonster(room.getMonsters().get(i));
                        result = "Monster is dead";
                    }
                    else{
                        result = "Monster has taken " + this.getWeaponType().attackValue + " points of damage";
                    }
            }
        }
        return result;
    }


    public String defend() {
        this.setDefenseType(DefenseType.SHIELD);
        return String.format("%s raises their %s", this.getName(), this.getDefenseType().type);
    }
}
