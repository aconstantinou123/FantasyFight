package Baddies;

public enum AttackModifier {
    ZERO ("misses", 0),
    SCRAPE ("scrapes", 1),
    NORMAL ("hits", 2),
    DOUBLE ("deals double damage to", 4),
    QUADRUPLE ("CRITICAL quad damage: ", 8);

    final String description;
    final int modifier;


    AttackModifier(String description, int modifier) {
        this.description = description;
        this.modifier = modifier;
    }

    public String getDescription() {
        return description;
    }

    public int getModifier() {
        return modifier;
    }
}
