package Players;

public enum DefenseType {

    SHIELD ("shield", 2),
    ANIMAL ("animal", 2),
    AURA ("aura", 2),
    NONE ("none", 1);


    final String type;
    final int defenceValue;

    DefenseType(String type, int defenceValue) {
        this.type = type;
        this.defenceValue = defenceValue;
    }

    public String getType() {
        return type;
    }

    public int getDefenceValue(){
        return defenceValue;
    }
}
