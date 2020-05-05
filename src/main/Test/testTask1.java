package junit.util;

import org.junit.Assert;
import org.junit.Test;

public class MidFunctionTest {
    @Test
    public void mid_test_1(){
        int expectedResult = 1;
        MidFunction mid = new MidFunction();
        int result = mid.findMid(2,3);
        Assert.assertEquals(expectedResult,result);
    }
    @Test
    public void mid_test_2(){
        int expectedResult = 2;
        MidFunction mid = new MidFunction();
        int result = mid.findMid(2,0);
        Assert.assertEquals(expectedResult,result);
    }
}
