package Players;

import Baddies.Monster;
import Rooms.Room;

public interface IMoves {

    public String attack(WeaponType weapon, String monsterName, Room room);
    public String defend(DefenseType defence);
}
