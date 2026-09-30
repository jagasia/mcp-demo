package com.upskillit.calculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * STEP 4 - VERIFY (the "spying" part)
 *
 * A spy (and a mock) remembers every method call.
 * verify(...) asks: "Was this method called?" - if not, the test fails.
 */
class Step4_VerifyTest {

    @Test
    void spy_remembersWhatWasCalled() {
        // TODO 1: Create a SPY Calculator.


        // TODO 2: Call add(2, 3) and then add(4, 5) on the spy.
        //         (No need to check the answers here.)


        // TODO 3: Verify that add(2, 3) was called.
        //         Hint: verify(spy).add(...)


        // TODO 4: Verify that add was called exactly 2 times, with ANY numbers.
        //         Hint: verify(spy, times(...)).add(anyInt(), anyInt())


        // TODO 5: Verify that multiply was NEVER called.
        //         Hint: never()


        // TODO 6: Delete the line below once the TODOs above are done.
        fail("Step 4 not done yet - complete the TODOs above");
    }

    // TRY THIS AFTER STEP 4 PASSES:
    // Change TODO 4 to times(3) and run again. Read the error message -
    // Mockito tells you exactly what was expected and what really happened.
}
