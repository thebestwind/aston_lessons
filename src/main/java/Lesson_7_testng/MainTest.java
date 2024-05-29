package Lesson_7_testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {
    @DataProvider(name = "factorialData")
    public static Object[][] factorialData() {
        return new Object[][] {
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorial(int input, int expected) {
        Assert.assertEquals(Main.factorial(input), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegativeNumber() {
        Main.factorial(-1);
    }
}
