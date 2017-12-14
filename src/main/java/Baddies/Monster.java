package Baddies;

import Players.Player;

import java.util.ArrayList;
import java.util.Random;

public abstract class Monster {

    private String name;
    private int healthValue;
    private int attackValue;
    private String monsterType;
    private AttackModifier attackModifier;

    public Monster(String name, int healthValue, int attackValue, String monsterType, AttackModifier attackModifier) {
        this.name = name;
        this.healthValue = healthValue;
        this.monsterType = monsterType;
        this.attackValue = attackValue;
        this.attackModifier = attackModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonsterType(){
        return this.monsterType;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    public AttackModifier getAttackModifier() {
        return attackModifier;
    }

    public void setAttackModifier(AttackModifier attackModifier) {
        this.attackModifier = attackModifier;
    }

    public String prettyName(){
        return getName() + " the " + getMonsterType();
    }

    public void randomAttack(){
        Random rand = new Random();
        int randomAttack = rand.nextInt(4) + 0;
        ArrayList<AttackModifier> powerlist = new ArrayList<>();
        powerlist.add(AttackModifier.ZERO);
        powerlist.add(AttackModifier.SCRAPE);
        powerlist.add(AttackModifier.NORMAL);
        powerlist.add(AttackModifier.DOUBLE);
        powerlist.add(AttackModifier.QUADRUPLE);
        this.attackModifier = powerlist.get(randomAttack);

    }

    public String attack(Player player){
        String result;
        if(healthValue >= 0){
            this.randomAttack();
            int postAttack = (player.getHealthValue() - ((this.attackValue * this.getAttackModifier().modifier)/ player.getDefenseType().getDefenceValue()));
            player.setHealthValue(postAttack);
            if(player.getHealthValue() <= 0){
                result = "Monster attacks! You have run out of health. You are dead...game...over";
            }
            else{
                result = "Monster attacks. " + player.getName() + " has new health value of " + player.getHealthValue();
            }
        }
        else {
            result = "can't attack, monster dead";
        }
        return result;
    }

}
