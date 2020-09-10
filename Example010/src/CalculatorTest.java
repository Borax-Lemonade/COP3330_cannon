import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    /*
    The calculator shall add 2 numbers
    The calculator shall subtract 2 numbers
     */

    @Test
    public void testAddNormalPositiveAndPositiveNumber() {
        Calculator c = new Calculator();
        long answer = c.add(2, 2);

        assertEquals(4, answer);
    }

    @Test
    public void testAddNormalPositiveAndNegativeNumber() {
        Calculator c = new Calculator();
        long answer = c.add(6, -2);

        assertEquals(4, answer);
    }

    @Test
    public void testAddNormalNegativeAndNegativeNumber() {
        Calculator c = new Calculator();
        long answer = c.add(-2, -2);

        assertEquals(-4, answer);
    }

    @Test
    public void testAddBigPositiveAndPositiveNumber() {
        Calculator c = new Calculator();

        assertEquals(2*Integer.MAX_VALUE, c.add(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

}