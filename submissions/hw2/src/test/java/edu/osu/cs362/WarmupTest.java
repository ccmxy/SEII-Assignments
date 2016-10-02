package edu.osu.cs362;

import static org.junit.Assert.*;
import org.junit.Test;


public class WarmupTest {@
    Test
    public void testFindIntegerExample() {

        int result = WarmUp.findInteger(new int[] {
            1, 2, 3, 4, 5
        }, 100);
        assertEquals(result, -1);


        for (int i = 1; i < 5; i++) {
            int result2 = WarmUp.findInteger(new int[] {
                1, 2, 3, 4, 5
            }, i + 1);
            assertEquals("findInteger(new int[]{1,2,3,4,5}," + i + ")", result2, i);
        }

        /*  assertion the incorrectly fails: */
        int result3 = WarmUp.findInteger(new int[] {
            1, 2, 3, 4, 5
        }, 1);
        assertEquals(result3, 0);

    }

    @
    Test
    public void testLastZero() {

        int result = WarmUp.lastZero(new int[] {
            1, 0, 4, 0, 5
        });
        assertEquals(result, 3);

        int result2 = WarmUp.lastZero(new int[] {
            1, 3, 4, 3, 5
        });
        assertEquals(result2, -1);

        int result3 = WarmUp.lastZero(new int[] {
            1, 0, 5
        });
        assertNotEquals(result3, 2);

        /*Assertion that incorrectly fails*/
        int result4 = WarmUp.lastZero(new int[] {
            0, 3, 4, 3, 5
        });
        assertEquals(result4, 0);


    }


    // This test causes an exception to be thrown because testLast contains a fatal error.
    @
    Test
    public void testLast() {
        int result = WarmUp.last(new int[] {
            1, 0, 4, 0, 5
        }, 4);
        assertEquals(result, 2);

        int result2 = WarmUp.last(new int[] {
            1, 3, 4, 3, 5
        }, 7);
        assertEquals(result2, -1);
    }


    @
    Test
    public void testPositive() {
        int result = WarmUp.positive(new int[] {
            -1, -2, 4, 5
        });
        assertEquals(result, 2);
    }

    @
    Test
    public void testOddOrPos() {
        int result = WarmUp.oddOrPos(new int[] {
            -3, -2, 3, 4
        });
        assertEquals(result, 2);
    }

}
