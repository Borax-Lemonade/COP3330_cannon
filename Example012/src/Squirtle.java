import java.security.SecureRandom;

public class Squirtle extends WaterMonster {
    private SecureRandom gen;
    private int hitpoints;
    private int attackPower;
    private int armor;

    public Squirtle(int hitpoints) {
        super("Squirtle", 10);

        gen = new SecureRandom();
        gen.setSeed(42);

        this.hitpoints = hitpoints;
        this.attackPower = 100;
    }


    public int attack(Squirtle otherMonster) {
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
