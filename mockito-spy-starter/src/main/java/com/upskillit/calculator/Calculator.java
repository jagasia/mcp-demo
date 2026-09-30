package com.upskillit.calculator;

/**
 * A very simple class we will test with a Mock and a Spy.
 * You do NOT need to change this file.
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    // Used only in the Bonus exercise (Step 5).
    // Dividing by 0 throws ArithmeticException.
    public int divide(int a, int b) {
        return a / b;
    }
}
