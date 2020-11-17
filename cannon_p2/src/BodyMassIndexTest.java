import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BodyMassIndexTest {
    //public BodyMassIndex bmi = new BodyMassIndex(62, 93);
    @Test
    void underweight() {
        assertEquals(17, new BodyMassIndex(62,93).bmiInput);
    }
    @Test
    void normal() {
        assertEquals(20.1, new BodyMassIndex(62,110).bmiInput);
    }
    @Test
    void overweight() {
        assertEquals(27.4, new BodyMassIndex(62,150).bmiInput);
    }
    @Test
    void obese() {
        assertEquals(33.1, new BodyMassIndex(62,181).bmiInput);
    }

    @Test
    void category_underweight() {
        assertEquals("Underweight", new BodyMassIndex(62,93).bmiCategory);
    }
    @Test
    void category_normal() {
        assertEquals("Normal", new BodyMassIndex(62,110).bmiCategory);
    }
    @Test
    void category_overweight() {
        assertEquals("Overweight", new BodyMassIndex(62,150).bmiCategory);
    }
    @Test
    void category_obese() {
        assertEquals("Obesity", new BodyMassIndex(62,181).bmiCategory);
    }
}
