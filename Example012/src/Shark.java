public class Shark extends WaterMonster implements  WaterMonsterBehavior {

    public Shark() {
        super(100);
    }

    @Override
    public void attack() {
        System.out.println("Shark attacks!");
    }

    @Override
    public void swim() {
        System.out.println("Shark swims!");
    }

    @Override
    public void defend() {
        System.out.println("Shark defends!");
    }
}
