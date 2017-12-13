import Baddies.AttackModifier;
import Baddies.Troll;
import Players.DefenseType;
import Players.Warrior;
import Players.WeaponType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MonsterTest {

    Warrior warrior;
    Warrior warrior2;
    Troll troll;

    @Before
    public void before(){
        warrior = new Warrior("Sword Boy", 1000, WeaponType.SWORD, DefenseType.NONE);
        warrior2 = new Warrior("Sword Boy", 1000, WeaponType.SWORD, DefenseType.SHIELD);
        troll = new Troll("Barry", 100, 50, AttackModifier.NORMAL);
    }

    @Test
    public void canGetTrollName(){
        assertEquals("Barry", troll.getName());
    }

    @Test
    public void canSetAttackModifier(){
        troll.setAttackModifier(AttackModifier.DOUBLE);
        assertEquals(AttackModifier.DOUBLE, troll.getAttackModifier());
    }

//    @Test
//    public void canAttackPlayer(){
//        troll.attack(warrior);
//        troll.attack(warrior2);
////        assertEquals(123, warrior.getHealthValue());
//        assertEquals(123, warrior2.getHealthValue());
//    }
}
