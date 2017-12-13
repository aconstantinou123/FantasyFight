import Baddies.AttackModifier;
import Baddies.Troll;
import Players.*;
import Rooms.Room;
import org.junit.Before;
import org.junit.Test;

import static Players.WeaponType.CLUB;
import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Warrior warrior;
    Wizard wizard;
    Cleric cleric;
    Troll troll;
    Room room;

    @Before
    public void before(){
        warrior = new Warrior("Sword Boy", 200, WeaponType.SWORD, DefenseType.NONE);
        wizard = new Wizard("Spell Boy", 100, WeaponType.SPELL, DefenseType.NONE);
        cleric = new Cleric("Heal Boy", 100, WeaponType.SPELL, DefenseType.NONE);
        room = new Room();
        troll = new Troll("Bob", 50, 50, "Troll", AttackModifier.NORMAL);
        room.addMonsters(troll);
    }

    @Test
    public void canGetName() {
        assertEquals("Sword Boy", warrior.getName());
    }

    @Test
    public void canSetWeapon(){
        warrior.setWeaponType(CLUB);
        assertEquals(WeaponType.CLUB, warrior.getWeaponType());
    }

    @Test
    public void canSetDefence(){
        warrior.setDefenseType(DefenseType.SHIELD);
        assertEquals(DefenseType.SHIELD, warrior.getDefenseType());
    }

    @Test
    public void canDefend(){
        assertEquals("Sword Boy raises their shield", warrior.defend());
    }

    @Test
    public void canAttackMonster(){
        warrior.attack("Bob", room);
        assertEquals(30, troll.getHealthValue());
    }

}
