package TestBuggy2;
import Buggy2.MidFuction2;
import org.junit.Assert;
import org.junit.Test;
public class TestMidFuction2 {
    @Test
    public void mid_test_1(){
        int expectedResult = 1;
        MidFuction2 mid = new MidFuction2();
        int result = mid.findMid(2,3);
        Assert.assertEquals(expectedResult,result);
    }
    @Test
    public void mid_test_2(){
        int expectedResult = 2;
        MidFuction2 mid = new MidFuction2();
        int result = mid.findMid(2,0);
        Assert.assertEquals(expectedResult,result);
    }
    @Test
    public void mid_test_3(){
        int expectedResult = 2;
        MidFuction2 mid = new MidFuction2();
        int result = mid.findMid(0,2);
        Assert.assertEquals(expectedResult,result);
    }
    @Test
    public void mid_test_4(){
        int expectedResult = 5;
        MidFuction2 mid = new MidFuction2();
        int result = mid.findMid(0,5);
        Assert.assertEquals(expectedResult,result);
    }
    @Test
    public void mid_test_6(){
        int expectedResult = 1;
        MidFuction2 mid = new MidFuction2();
        int result = mid.findMid(7,3);
        Assert.assertEquals(expectedResult,result);
    }
}
