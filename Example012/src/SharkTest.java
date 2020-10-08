import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharkTest {
    @Test
    void testGetName() {
        Shark s1 = new Shark(100);
        assertEquals("Shark", s1.getName());
    }

    @Test
    void testAttack() {
        Shark s1 = new Shark(100);
        Shark s2 = new Shark(100);

        int HP_s2 = s2.getHitpoints();

        int damageInflicted = s1.attack(s2);

        assertTrue(damageInflicted >= 0);
    }

    @Test
    void testSharkAttacksSquirtle() {
        Shark s1 = new Shark(100);
        Squirtle s2 = new Squirtle(1200);

        int s2_hp = s2.getHitpoints();

        int damageInflicted = s1.attack(s2);

        assertTrue(s2.getHitpoints() <= s2_hp);
    }

    @Test
    void testDefend() {
        Shark s1 = new Shark(100);

        int damageTaken = s1.defend(100);

        assertTrue(damageTaken >= 0);
    }

    @Test
    public void testUpdateHitpoints() {
        Shark s1 = new Shark(100);
        s1.updateHitpoints(10);

        assertEquals(90, s1.getHitpoints());
    }
}