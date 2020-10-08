import java.security.SecureRandom;

public class Shark extends WaterMonster {
    private SecureRandom gen;
    private int hitpoints;
    private int attackPower;
    private int armor;

    public Shark(int hitpoints) {
        super("Shark", 10);

        gen = new SecureRandom();
        gen.setSeed(42);

        this.hitpoints = hitpoints;
        this.attackPower = 100;
    }

    public int attack(WaterMonster otherMonster) {
        int attackerDamage = gen.nextInt(attackPower);

        System.out.printf("Squirtle attacks %s for %d damage!\n", otherMonster.getName(), attackerDamage);

        return otherMonster.defend(attackerDamage);
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int value) {
        hitpoints = value;
    }

    public void updateHitpoints(int adjustment) {
        setHitpoints(getHitpoints() - adjustment);
        System.out.printf("Squirtle now has %d hitpoints left!\n", getHitpoints());
    }
}
