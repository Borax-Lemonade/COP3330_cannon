public class Kracken extends WaterMonster implements MultiarmedBehavior, WaterMonsterBehavior {
    public Kracken() {
        super(010);
    }

    @Override
    public void attack() {
        System.out.println("Kracken attacks!");
    }

    @Override
    public void swim() {

    }

    @Override
    public void defend() {
        System.out.println("Kracken defends!");
    }

    @Override
    public void grasp() {

    }
 }
