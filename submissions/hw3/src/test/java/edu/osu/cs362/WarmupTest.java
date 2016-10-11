package edu.osu.cs362;

import static org.junit.Assert.*;
import org.junit.Test;



public class WarmupTest {
 @
 Test
 public void testFindIntegerExample() {

  int result = WarmUp.findInteger(new int[] {
   1,
   2,
   3,
   4,
   5
  }, 100);
  assertEquals(result, -1);


  for (int i = 1; i < 5; i++) {
   int result2 = WarmUp.findInteger(new int[] {
    1,
    2,
    3,
    4,
    5
   }, i + 1);
   assertEquals("findInteger(new int[]{1,2,3,4,5}," + i + ")", result2, i);
  }

  /*  assertion the incorrectly fails: */
  int result3 = WarmUp.findInteger(new int[] {
   1,
   2,
   3,
   4,
   5
  }, 1);
  assertEquals(result3, 0);

 }


 /************************
 **************************
 **************************

     lastZero

 **************************
 **************************
 **************************/

 //Testing with null input: causes
 // exception to be thrown.
 @
 Test
 public void testLastZero_nullValue() {
  int result = WarmUp.lastZero(null);
  assertEquals(result, -1);

 }

 //Testing with empty int array
 @
 Test
 public void testLastZero_emptyArray() {
  int result = WarmUp.lastZero(new int[] {

  });
  assertEquals(result, -1);

 }

 //Testing with multiple 0s
 @
 Test
 public void testLastZero_multipleZeros() {
  int result = WarmUp.lastZero(new int[] {
   1,
   0,
   4,
   0,
   5
  });
  assertEquals(result, 3);
 }

 //Testing with exactly 1 zero
 @
 Test
 public void testLastZero_oneZero() {

  int result3 = WarmUp.lastZero(new int[] {
   1,
   0,
   5
  });
  assertNotEquals(result3, 2);

 }

 //Testing with zero at position 0: Fails!
 @
 Test
 public void testLastZero_zeroAtPositionZero() {

  int result4 = WarmUp.lastZero(new int[] {
   0,
   3,
   4,
   3,
   5
  });
  assertEquals(result4, 0);
 }

 //Testing with no 0s
 @
 Test
 public void testLastZero_noZeros() {

  int result2 = WarmUp.lastZero(new int[] {
   1,
   3,
   4,
   3,
   5
  });
  assertEquals(result2, -1);
 }


 /************************
 **************************
 **************************

     last

 **************************
 **************************
 **************************/


 //Test for null sent in. Passes because
 // the function accounts for null values.
 @
 Test
 public void testLast_nullValue() {
  int result = WarmUp.last(null, 0);
  assertEquals(result, -1);
 }


 // All of these tests cause
 // an exception to be thrown because
 //testLast contains a fatal error.

 @
 Test
 public void testLast_valToFindInArrayOnce() {
  int result = WarmUp.last(new int[] {
   1,
   0,
   2,
   5
  }, 0);
  assertEquals(result, 1);
 }

 @
 Test
 public void testLast_valToFindInArrayTwice() {
  int result = WarmUp.last(new int[] {
   1,
   0,
   4,
   0,
   5
  }, 0);
  assertEquals(result, 3);
 }

 @
 Test
 public void testLast_toFindNotInArray() {
  int result = WarmUp.last(new int[] {
   1,
   3,
   4,
   3,
   5
  }, 7);
  assertEquals(result, -1);
 }



 /************************
 **************************
 **************************

     positive

 **************************
 **************************
 **************************/

 //Test for null sent in: Error is thrown
 @
 Test
 public void testPositive_nullValue() {
  int result = WarmUp.positive(null);
  assertEquals(result, 0);
 }


 //Tests on empty int array
 @
 Test
 public void testPositive_emptyArray() {
  int result = WarmUp.positive(new int[0]);
  assertEquals(result, 0);
 }

 //Test on int array with both positive and
 //negative values
 @
 Test
 public void testPositive_mixedData() {
  int result = WarmUp.positive(new int[] {
   -1, -2, 4, 5
  });
  assertEquals(result, 2);
 }



 //Test on int array with both positive and
 //negative values, as well as 0, which is
 //not positive or negative
 @
 Test
 public void testPositive_mixedDataWithZero() {
  int result = WarmUp.positive(new int[] {
   -1, -2, 0, 4, 5
  });
  assertEquals(result, 2);
 }



 //Test on int array with only negative
 // values.
 @
 Test
 public void testPositive_onlyNegatives() {
  int result = WarmUp.positive(new int[] {
   -1, -2, -3, -4, -5
  });
  assertEquals(result, 0);
 }


 //Test on int array with only positive
 // values.
 @
 Test
 public void testPositive_onlyPositives() {
  int result = WarmUp.positive(new int[] {
   1,
   2,
   3,
   4,
   5
  });
  assertEquals(result, 5);
 }



 /************************
 **************************
 **************************

     oddOrPos

 **************************
 **************************
 **************************/

 //Test on normal array of mixed data: Fails
 @
 Test
 public void testOddOrPos_mixedData() {
  int result = WarmUp.oddOrPos(new int[] {
   -3, -2, 3, 4
  });
  assertEquals(result, 3);
 }

 //Test on mixed (even/odd) list of positive numbers
 @
 Test
 public void testOddOrPos_mixedPositiveNumbers() {
  int result = WarmUp.oddOrPos(new int[] {
   1,
   2,
   3,
   4
  });
  assertEquals(result, 4);
 }


 //Test on odd negative numbers: FAILS!
 @
 Test
 public void testOddOrPos_oddNegativeNumbers() {
  int result = WarmUp.oddOrPos(new int[] {
   -1, -3, -5
  });
  assertEquals(result, 3);
  //Result retreived was 0 instead of 3
  //Bug discovered: A negative odd integer
  // % 2 will be -1, not 1, because in java %
  // includes negatives.
 }


 //Test on empty int array
 @
 Test
 public void testOddOrPos_emptyIntArray() {
  //Test on blank int array
  int[] myIntArray = new int[3];
  int result = WarmUp.oddOrPos(myIntArray);
  assertEquals(result, 0);
 }

 //Test on int array that points to null:
 // Exception is thrown
 @
 Test
 public void testOddOrPos_nullIntArray() {
  int[] myIntArray = null;
  int result = WarmUp.oddOrPos(myIntArray);
  assertEquals(result, 0);
 }


 //Test just sending null into params:
 // Exception is thrown
 @
 Test
 public void testOddOrPos_nullValue() {
  int result = WarmUp.oddOrPos(null);
  assertEquals(result, 0);
 }

}
