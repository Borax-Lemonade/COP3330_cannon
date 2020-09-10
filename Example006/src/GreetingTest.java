import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GreetingTest {
    @Test
    public void testGreetingDefaultConstructor() {
        Greeting g = new Greeting();
        assertEquals("Hello, World!", g.toString());
    }

    @Test
    public void testGreetingParamConstructor() {
        Greeting g = new Greeting("Welcome");
        assertEquals("Welcome, World!", g.toString());
    }
}