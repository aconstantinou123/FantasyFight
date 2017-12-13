import Baddies.AttackModifier;
import Baddies.Dragon;
import Baddies.Orc;
import Baddies.Troll;
import Rooms.Room;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room;
    Troll troll;
    Dragon dragon;
    Orc orc;

    @Before
    public void before(){
        room = new Room();
        troll = new Troll("Steve", 50, 50, "Troll", AttackModifier.NORMAL);
        dragon = new Dragon("Harry", 50, 50, "Dragon", AttackModifier.NORMAL);
        orc = new Orc("Robert", 50, 50, "Orc", AttackModifier.NORMAL);
        room.addMonsters(troll);
        room.addMonsters(dragon);
        room.addMonsters(orc);
    }

    @Test
    public void canListAllMonsters(){
        assertEquals("Steve the Troll \n" +
                "Harry the Dragon \n" +
                "Robert the Orc \n", room.listAllMonsters());
    }
}
