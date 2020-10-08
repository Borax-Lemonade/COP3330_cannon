public class Squirtle extends WaterMonster implements  WaterMonsterBehavior {
    public Squirtle(int hitpoints) {
        super(hitpoints);
    }

    @Override
    public void attack() {
        System.out.println("Squirtle attacks!");
    }

    @Override
    public void swim() {
        System.out.println("Squirtle moves!");
    }

    @Override
    public void defend() {
        System.out.println("Squirtle defends!");
        setHitpoints(getHitpoints() - 10);
        System.out.printf("Squirtle now has %d hitpoints left!\n", getHitpoints());
    }
}
