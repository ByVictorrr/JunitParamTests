package calculator;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) // use parameterized runner (JUnit runner)
public class CalculatorImplTest {
    // step 1  - for parameterized
    private int num1;
    private int num2;
    private int expectedResults;

    // step 2 - create constructor
    public CalculatorImplTest(int num1, int num2, int results){
        this.num1 = num1;
        this.num2 = num2;
        this.expectedResults = results;
    }

    // Step 3 - create constructor store params
    @Parameterized.Parameters
    public static Collection<Integer []> data(){
        /* Parameterized.class runner knows to invoke this by @Parameters (static method)
        *  gets the data set to create an instance of this class then executes @Test method
        *  For each data set it does that and tests
        */

       return Arrays.asList(new Integer[][]{
               // {num1, num2, result} for each {}
               { -1, 2, 1 },
               { 1, 2, 3 },
               { 6, 7, 13 }
       });
    }

    @Test
    public void add_Should_Return_A_Result(){
        Calculator c = new CalculatorImpl();
        int result = c.add(this.num1, this.num2);
        assertEquals(this.expectedResults, result);
    }
}
