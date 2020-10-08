import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquirtleTest {

    @Test
    void getName() {
    }

    @Test
    void testAttack() {
        Squirtle s1 = new Squirtle(100);
        Squirtle s2 = new Squirtle(100);

        int HP_s2 = s2.getHitpoints();

        int damageInflicted = s1.attack(s2);

        assertTrue(damageInflicted >= 0);
    }

    @Test
    void swim() {
    }

    @Test
    void testDefend() {
        Squirtle s1 = new Squirtle(100);

        int damageTaken = s1.defend(100);

        assertTrue(damageTaken >= 0);
    }

    @Test
    public void testUpdateHitpoints() {
        Squirtle s1 = new Squirtle(100);
        s1.updateHitpoints(10);

        assertEquals(90, s1.getHitpoints());
    }
}