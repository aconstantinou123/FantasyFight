package Players;

import Baddies.Monster;
import Rooms.Room;

public interface IMoves {

    public String attack(String monsterName, Room room);
    public String defend();
}
