package com.upskillit.calculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;

/**
 * STEP 2 - SPY
 *
 * A spy wraps a REAL object. If you don't change anything,
 * every method runs the real code and gives the real answer.
 */
class Step2_SpyTest {

    @Test
    void spy_runsRealCode() {
        // TODO 1: Create a SPY Calculator.
        //         Hint: use Mockito.spy(...) and pass a REAL object: new Calculator()
    				Calculator spy = Mockito.spy(Calculator.class);

    				doReturn(50).when(spy).add(2, 3);
    				
        // TODO 2: Call add(2, 3) on the spy and check the answer.
        //         Compare with Step 1 - is it different? Why?
    				int actual = spy.add(2, 3);
    				int expected=5;
    				assertEquals(expected, actual);

        // TODO 3: Call multiply(2, 3) on the spy and check the answer.


        // TODO 4: Delete the line below once the TODOs above are done.
//        fail("Step 2 not done yet - complete the TODOs above");
    }
}
