package JavaTest;

import Task.Task1;
import org.junit.Assert;
import org.junit.Test;

public class TestTask {
    @Test
    public void mid_test_1(){
        int expectedResult = 1;
        Task1 mid = new Task1();
        int result = mid.findMid(2,3);
        Assert.assertEquals(expectedResult,result);
    }
    @Test
    public void mid_test_2(){
        int expectedResult = 3;
        Task1 mid = new Task1();
        int result = mid.findMid(2,0);
        Assert.assertEquals(expectedResult,result);
    }
}
