import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    public void init() {
        calc = new Calculator();
    }

    @Test
    public void testAdditionTwoPositiveValues() {
        double answer = calc.add(10, 20);

        assertEquals(30, answer);
    }

    @Test
    public void testAdditionOnePositiveOneNegativeValue() {
        double answer = calc.add(-10, 10);

        assertEquals(0, answer);
    }

    @Test
    public void testAdditionTwoNegativeValues() {
        double answer = calc.add(-10, -10);

        assertEquals(-20, answer);
    }

    @Test
    public void testAdditionLargeValues() {

    }

    @Test
    void testSubTwoPositiveValues() {
        double answer = calc.sub(10, 10);
        assertEquals(0, answer);
    }
}