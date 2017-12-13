package Baddies;

public class Dragon extends Monster {

    public Dragon(String name, int healthValue, int attackValue, String monsterType, AttackModifier attackModifier) {
        super(name, healthValue, attackValue, monsterType, attackModifier);
    }

    public String prettyName(){
        return getName() + " the " + getMonsterType();
    }
}
