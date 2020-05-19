package Fitness;

import GzFaulocalization.FaulResult;
import GzFaulocalization.Faulocalizator;
import GzFaulocalization.TestCaseObj;
import Helper.Rater;
import Helper.TestCaseDetector;
import ObjectGenProg.TestCase;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Fitnesser {
    private int numOfTestPass;
    private int numOfTestFail;
    private List<TestCaseObj> listOriginTestCase;// list origin testcase
    private List<TestCaseObj> listCurrentTestCase;// list testcase pass
    public Fitnesser(int numOfTestPass, int numOfTestFail){
        this.numOfTestPass = numOfTestPass;
        this.numOfTestFail = numOfTestFail;
    }
    public Fitnesser(List<TestCaseObj> listOriginTestCase, List<TestCaseObj> listCurrentTestCase) {
        this.listOriginTestCase = listOriginTestCase;
        this.listCurrentTestCase = listCurrentTestCase;
    }
    public float getMaxPoint(){
        return Rater.setRateOfNegativeTest()* numOfTestFail + Rater.setRateOfPositiveTest()* numOfTestPass;
    }
    public float getFinessPoint(){
        int numOfNegTestPass = 0;
        int numOfPosTestPass = 0;
        for(TestCaseObj testCaseObjCurrent : listCurrentTestCase) {
            for(TestCaseObj testCaseObjOrigin: listOriginTestCase) {
                if(testCaseObjCurrent.getTestCaseName().equals(testCaseObjOrigin.getTestCaseName())
                        && testCaseObjOrigin.getNegativeTest()) {
                    numOfNegTestPass ++;
                }
                else if(testCaseObjCurrent.getTestCaseName().equals(testCaseObjOrigin.getTestCaseName())
                        && !testCaseObjOrigin.getNegativeTest()) {
                    numOfPosTestPass ++;
                }
            }
        }
        System.out.println("NT : " + numOfNegTestPass);
        System.out.println("PT : " + numOfPosTestPass);
        return Rater.setRateOfNegativeTest() * numOfNegTestPass + Rater.setRateOfPositiveTest() * numOfPosTestPass;
    }


}
