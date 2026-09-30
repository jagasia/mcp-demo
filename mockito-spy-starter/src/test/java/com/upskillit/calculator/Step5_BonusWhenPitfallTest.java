package com.upskillit.calculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * STEP 5 - BONUS: WHY doReturn() AND NOT when() FOR SPIES?
 *
 * divide(10, 0) throws ArithmeticException in the real Calculator.
 *
 * With   when(spy.divide(10, 0))   Java runs spy.divide(10, 0) FIRST
 * - and on a spy that is the REAL code - so it crashes before Mockito can fake it.
 *
 * With   doReturn(...).when(spy).divide(10, 0)   the real code never runs.
 */
class Step5_BonusWhenPitfallTest {

    @Test
    void spy_whenStyle_crashes() {
        // TODO 1: Create a SPY Calculator.


        // TODO 2: Try to fake divide(10, 0) to return 999 using the when() style:
        //             when(spy.divide(10, 0)).thenReturn(999);
        //         Run the test. What error do you see? Why?


        // TODO 3: Now wrap your TODO 2 line in assertThrows(...) so the test
        //         passes by EXPECTING the crash.
        //         Hint: assertThrows(ArithmeticException.class, () -> ...);


        // TODO 4: Delete the line below once the TODOs above are done.
        fail("Step 5a not done yet - complete the TODOs above");
    }

    @Test
    void spy_doReturnStyle_works() {
        // TODO 1: Create a SPY Calculator.


        // TODO 2: Fake divide(10, 0) to return 999 using the doReturn() style.


        // TODO 3: Check that divide(10, 0) returns 999 - no crash this time!


        // TODO 4: Delete the line below once the TODOs above are done.
        fail("Step 5b not done yet - complete the TODOs above");
    }
}
