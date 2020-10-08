public abstract class WaterMonster {
    protected int hitpoints;
    private int mana;
    private int armor;
    private int speed;
    private int level;

    public WaterMonster(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int value) {
        hitpoints = value;
    }
}
