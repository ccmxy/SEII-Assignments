package edu.osu.sort;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.junit.Before; // for @Before
import org.junit.BeforeClass; 
import org.junit.Rule; // for @Rule
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.rules.TestRule;



public class SortTest  {

    protected int elemUBound = 1000;

    @Rule
    public TestRule outputName = new TestWatcher(){
      protected void starting(Description description){
        System.out.println("Running " + description.getMethodName());
      }
    };


    // @Before
    // public void getNumElements(){
    //  Random randomGenerator = new Random();
    //  int n = randomGenerator.nextInt(1000);
    //
    // //  long seed = System.currentTimeMillis();
    //   // r = new Random(seed);
    //   System.out.printf("\n==============\nTesting 5t4on list of size: %d \n==============\n", n);
    // }
    // //


    private static List<Integer> getRandomIntegerList(int minNumElements, int maxNumElements, int elemUBound, int elemLBound){
      List<Integer> randomNumList = new ArrayList<>();
      Random seed = new Random();
      int numElements = seed.nextInt(((maxNumElements - minNumElements) + 1) + minNumElements);

      for (int idx = 0; idx < numElements; ++idx){
        seed = new Random();
        int randomElement = seed.nextInt(((elemUBound - elemLBound) + 1) + elemLBound);
        randomNumList.add(randomElement);
      }
      Collections.shuffle(randomNumList); //just some extra shufflin
      return randomNumList;
    }

    @Test
    public void randomTestOracle() {
      int n_runs = 100;
    	for(int i=0;i<n_runs;i++){

    	    // Generate a random array between size 0 and 1000,
          //with lower and upper element bounds of 0 and elemUBound
    	    List<Integer> sorted = getRandomIntegerList(0, 1000, 0, elemUBound);
          System.out.printf("\n==============\nTesting on list of size: %d \n==============\n", sorted.size());

    	    // Copy the sorted array before sorting it
    	    List<Integer> original = new ArrayList(sorted);

    	    // Sort it
    	    Sort.sort(sorted);

    	    // Test the result
    	     assertTrue(SortOracle.isSorted(original,sorted));
           randomTestAssertion(original, sorted);
    	  }

    }

    public void randomTestAssertion(List<Integer> original, List<Integer>sorted) {
      assertTrue(SortOracle.isSorted(original,sorted));



    }
}
