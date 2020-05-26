package Helper;

public class Rater {
    private final static float WNRate = 1.0f;
    private final static float WPRate = 0.01f;
    private final static int NUMOFVARIANTS = 10;
    private final static int NUMOFGENS = 3;
    private final static float MUTATIONRate = 0.05f;
    public static float setRateOfNegativeTest(){
        return WNRate;
    }
    public  static float setRateOfPositiveTest(){
        return WPRate;
    }
}
