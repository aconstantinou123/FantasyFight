package Players;

public enum WeaponType {

    SWORD ("sword", 20),
    CLUB ("club", 30),
    AXE ("axe", 50),
    SPELL ("spell", 50);

  final String type;
  final int attackValue;


    WeaponType(String type, int attackValue) {
        this.type = type;
        this.attackValue = attackValue;
    }

    public String getType() {
        return type;
    }

    public int getAttackValue() {
        return attackValue;
    }
}
