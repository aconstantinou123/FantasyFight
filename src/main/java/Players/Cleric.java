package Players;

import Rooms.Room;

public class Cleric extends Player implements IMoves {
    public Cleric(String name, int healthValue, WeaponType weaponType, DefenseType defenseType) {
        super(name, healthValue, weaponType, defenseType);
    }

    @Override
    public String attack(WeaponType weapon, String monsterName, Room room) {
        return null;
    }

    public String defend() {
        this.setDefenseType(DefenseType.AURA);
        return String.format("%s raises their %s", this.getName(), this.getDefenseType().type);
    }
}
