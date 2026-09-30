package com.upskillit.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * STEP 0 - WARM-UP (already done for you)
 *
 * A normal test with a normal object. No Mockito yet.
 * Read this first so you know the pattern:
 *   1. Create the object
 *   2. Call a method
 *   3. Check the answer with assertEquals(expected, actual)
 *
 * This test already passes. Nothing to do here.
 */
class Step0_RealCalculatorTest {

    @Test
    void realCalculator_addsAndMultiplies() {
        // 1. Create a normal object
        Calculator calc = new Calculator();

        // 2 + 3. Call methods and check the answers
        assertEquals(5, calc.add(2, 3));
        assertEquals(6, calc.multiply(2, 3));
    }
}
