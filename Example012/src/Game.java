import java.util.ArrayList;

public class Game {
    public static void  main(String[] args) {
        /*
        //ArrayList<WaterMonsterBehavior> monsters = new ArrayList<>();
        //monsters.add(new Squirtle(100));
        //monsters.add(new Squirtle(110));

        for(WaterMonsterBehavior m : monsters) {
            OrderAttack(m);
            OrderDefend(m);
        }
        */
    }

    public static void OrderAttack(WaterMonsterBehavior monster) {
        monster.attack(null);
    }

    public static void OrderDefend(WaterMonsterBehavior monster) {
        monster.defend(0);
    }
}
