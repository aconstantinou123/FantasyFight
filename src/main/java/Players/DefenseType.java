package Players;

public enum DefenseType {

    SHIELD ("shield"),
    ANIMAL ("animal"),
    AURA ("aura"),
    NONE ("none");


    final String type;

    DefenseType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
