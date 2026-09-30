package com.upskillit.calculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

/**
 * STEP 1 - MOCK
 *
 * A mock is a FAKE object. Its methods never run the real code.
 * If you don't tell it what to return, it returns a default value (0 for int).
 */
class Step1_MockTest {

    @Test
    void mock_returnsZero_becauseRealCodeDoesNotRun() {
        // TODO 1: Create a MOCK Calculator.
        //         Hint: use Mockito.mock(...) and pass Calculator.class
    		Calculator mock = Mockito.mock(Calculator.class);


        // TODO 2: Call add(2, 3) on the mock and check the answer.
        //         What number do you expect? (Not 5!)	ans: i expect 0
    		int actual = mock.add(2, 3);
    		int expected=5;
    		assertEquals(expected, actual);


        // TODO 3: Call multiply(2, 3) on the mock and check the answer.
    		
    		actual=mock.multiply(2, 3);
    		expected=6;
    		assertEquals(expected, actual);


        // TODO 4: Delete the line below once the TODOs above are done.
//        fail("Step 1a not done yet - complete the TODOs above");
    }

    @Test
    void mock_returnsWhatYouTellIt() {
        // TODO 1: Create a MOCK Calculator.
    		Calculator mock = Mockito.mock(Calculator.class);


        // TODO 2: Tell the mock: "when add(2, 3) is called, return 50".
        //         Hint: when(...).thenReturn(...)   (this form is fine for mocks)
    		when(mock.add(2, 3)).thenReturn(50);

        // TODO 3: Check that add(2, 3) now returns 50.
    		int actual = mock.add(2, 3);
    		int expected=50;
    		assertEquals(expected, actual);

        // TODO 4: Check what add(10, 10) returns.
        //         You did NOT set it up - so what does a mock give back?
    		actual=mock.add(10, 10);
    		expected=20;
    		assertEquals(expected, actual);


        // TODO 5: Delete the line below once the TODOs above are done.
//        fail("Step 1b not done yet - complete the TODOs above");
    }
}
