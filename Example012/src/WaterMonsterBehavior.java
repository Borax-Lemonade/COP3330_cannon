public interface WaterMonsterBehavior {
    String getName();

    void attack(WaterMonsterBehavior otherMonster);

    void swim();

    void defend(int attackerDamage);
}
