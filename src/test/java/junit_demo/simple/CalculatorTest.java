package junit_demo.simple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithANegativeValue() {
        calculator.add(-1, 0);
    }

    @Test
    public void addWithPositiveNumbers() {
        assertEquals(4, calculator.add(1, 3));
    }

    @After
    public void tearDown() {
        calculator = null;
    }
}