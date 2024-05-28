package lesson7_junit_5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    public void testFactorial() {
        assertEquals(1, Main.factorial(0));
        assertEquals(1, Main.factorial(1));
        assertEquals(2, Main.factorial(2));
        assertEquals(6, Main.factorial(3));
        assertEquals(24, Main.factorial(4));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Main.factorial(-3),
                "Expected getFactorial() to throw, but it didn't");
        assertEquals("Введите неотрицательное число", exception.getMessage());
    }
}