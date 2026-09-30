package com.upskillit.calculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;

/**
 * STEP 3 - SPY + FAKE ONE METHOD
 *
 * The object is real, but you can fake the methods you choose.
 * With a spy, ALWAYS use:   doReturn(value).when(spy).method(args);
 */
class Step3_SpyWithFakeMethodTest {

    @Test
    void spy_fakeOnlyMultiply_addStaysReal() {
        // TODO 1: Create a SPY Calculator.


        // TODO 2: Make multiply(2, 3) return 100 instead of 6.
        //         Hint: doReturn(...).when(...).multiply(...)


        // TODO 3: Check that multiply(2, 3) now returns 100 (fake).


        // TODO 4: Check that add(2, 3) still returns 5 (real - you did not fake it).


        // TODO 5: Delete the line below once the TODOs above are done.
        fail("Step 3a not done yet - complete the TODOs above");
    }

    @Test
    void spy_fakeOnlyWorksForTheExactArguments() {
        // TODO 1: Create a SPY Calculator.


        // TODO 2: Make multiply(2, 3) return 100.


        // TODO 3: Check what multiply(3, 4) returns.
        //         You only faked (2, 3) - so is (3, 4) fake or real?


        // TODO 4: Delete the line below once the TODOs above are done.
        fail("Step 3b not done yet - complete the TODOs above");
    }
}
