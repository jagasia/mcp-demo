# Mockito Mock vs Spy – Starter Project

Practice project for the Calculator example: see the difference between a **Mock** and a **Spy** by writing the tests yourself.

## Requirements

- Java 17 or newer
- Maven 3.8+ (or open the project in IntelliJ IDEA / Eclipse / VS Code; they use Maven automatically)

## How to run

```bash
mvn test
```

Or right-click a test file in your IDE and choose **Run**.

At the start, every test except Step 0 is **red (failing)**. That is expected: each one has a `fail("... not done yet ...")` line. Your goal is to make all of them **green**.

## Project layout

```
src/main/java/com/upskillit/calculator/
    Calculator.java                    <- the class being tested (don't change it)

src/test/java/com/upskillit/calculator/
    Step0_RealCalculatorTest.java      <- warm-up, already done: read it first
    Step1_MockTest.java                <- Mock: fake object, returns 0
    Step2_SpyTest.java                 <- Spy: real object, real answers
    Step3_SpyWithFakeMethodTest.java   <- Spy: fake ONE method with doReturn()
    Step4_VerifyTest.java              <- verify(), times(), never()
    Step5_BonusWhenPitfallTest.java    <- Bonus: why when() breaks with spies
```

## How to work through it

1. Open one Step file at a time, in order.
2. Follow the `// TODO` comments from top to bottom.
3. Delete the `fail(...)` line at the end of the test when you're done.
4. Run the test. Green means you got it; red means read the error message and try again.

## Cheat sheet

| What you want | Code |
|---|---|
| Create a mock | `Calculator calc = Mockito.mock(Calculator.class);` |
| Create a spy | `Calculator calc = Mockito.spy(new Calculator());` |
| Fake a method (mock) | `when(calc.add(2, 3)).thenReturn(50);` |
| Fake a method (spy) | `doReturn(100).when(calc).multiply(2, 3);` |
| Check the answer | `assertEquals(expected, actual);` |
| Was it called? | `verify(calc).add(2, 3);` |
| Called N times? | `verify(calc, times(2)).add(anyInt(), anyInt());` |
| Never called? | `verify(calc, never()).multiply(anyInt(), anyInt());` |
