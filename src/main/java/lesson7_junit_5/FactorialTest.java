package lesson7_junit_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    void testFactorial() {
        assertEquals(1, Main.factorial(0));
        assertEquals(1, Main.factorial(1));
        assertEquals(2, Main.factorial(2));
        assertEquals(6, Main.factorial(3));
        assertEquals(24, Main.factorial(4));
    }

    @Test
    void testFactorialNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Main.factorial(-1), "Expected factorial to throw, but it didn't");
    }
}
