import Baddies.AttackModifier;
import Baddies.Dragon;
import Baddies.Orc;
import Baddies.Troll;
import Players.*;
import Rooms.Room;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RoomTest {

    Room room;
    Room room2;
    Troll troll;
    Dragon dragon;
    Orc orc;
    Warrior warrior;
    Wizard wizard;
    Cleric cleric;

    @Before
    public void before(){
        room = new Room();
        room2 = new Room();
        troll = new Troll("Steve", 50, 50, "Troll", AttackModifier.NORMAL);
        dragon = new Dragon("Harry", 50, 50, "Dragon", AttackModifier.NORMAL);
        orc = new Orc("Robert", 50, 50, "Orc", AttackModifier.NORMAL);
        warrior = new Warrior("Sword Boy", 200, WeaponType.SWORD, DefenseType.NONE);
        wizard = new Wizard("Spell Boy", 100, WeaponType.SPELL, DefenseType.NONE);
        cleric = new Cleric("Heal Boy", 100, WeaponType.SPELL, DefenseType.NONE);
        room.addMonsters(troll);
        room.addMonsters(dragon);
        room.addMonsters(orc);
        room.addPlayerz(warrior);
        room.addPlayerz(wizard);
        room.addPlayerz(cleric);
    }

    @Test
    public void canListAllMonsters() {
        assertEquals("Steve the Troll \n" +
                "Harry the Dragon \n" +
                "Robert the Orc \n", room.listAllMonsters());
    }
    @Test
    public void canHeal(){
        cleric.heal(room, "Spell Boy");
        assertEquals(200, wizard.getHealthValue());
    }

    @Test
    public void roomCheck_False(){
        assertEquals(false, room.checkRoomEmpty());
    }

    @Test
    public void roomCheck_True(){
        assertEquals(true, room2.checkRoomEmpty());
    }
}
