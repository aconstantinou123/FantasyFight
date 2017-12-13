import Players.*;
import org.junit.Before;
import org.junit.Test;

import static Players.WeaponType.CLUB;
import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Warrior warrior;
    Wizard wizard;
    Cleric cleric;

    @Before
    public void before(){
        warrior = new Warrior("Sword Boy", 200, WeaponType.SWORD, DefenseType.NONE);
        wizard = new Wizard("Spell Boy", 100, WeaponType.SPELL, DefenseType.NONE);
        cleric = new Cleric("Heal Boy", 100, WeaponType.SPELL, DefenseType.NONE);
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

}
