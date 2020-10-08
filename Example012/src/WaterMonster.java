public abstract class WaterMonster {
    private int armor;

    private String name;

    public WaterMonster(String name, int armor) {
        this.name = name;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int defend(int attackerDamage) {
        int damageTaken = Math.max(attackerDamage - armor, 0);

        System.out.printf("%s defends and takes %d hitpoints of damage!\n", name, damageTaken);
        return damageTaken;
    }
}
