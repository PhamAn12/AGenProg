package Helper;

public class Rater {
    private final static float WNRate = 1.0f;
    private final static float WPRate = 0.01f;
    public static float setRateOfNegativeTest(){
        return WNRate;
    }
    public  static float setRateOfPositiveTest(){
        return WPRate;
    }
}
