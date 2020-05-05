package GzFaulocalization;

import ObjectGenProg.TestCase;

import java.util.List;
import java.util.Map;

public class FaulResult {
    private int totalTest;
    private int numOfTestPass;
    private int numOfTestFail;
    List<TestCaseObj> testSuite;
    Map<SuspiciousCode, Float> scoreOfLine;
    List<SuspiciousCode> listSuspiciousCode;
    public FaulResult(int totalTest, int numOfTestPass, int numOfTestFail,List<TestCaseObj> testSuite, List<SuspiciousCode> listSuspiciousCode) {
        this.totalTest = totalTest;
        this.numOfTestPass = numOfTestPass;
        this.numOfTestFail = numOfTestFail;
        this.listSuspiciousCode = listSuspiciousCode;
        this.testSuite = testSuite;
    }
    public void printResult(){
        System.out.println("total test : " + totalTest + " num of test pass : "
                + numOfTestPass + " num of test fail :" + numOfTestFail);
        for(SuspiciousCode sc : listSuspiciousCode){
            sc.printDataSuspicious();
        }
        for(TestCaseObj testCaseObj : testSuite){
            testCaseObj.printTest();
        }
    }

    public int getTotalTest() {
        return totalTest;
    }

    public void setTotalTest(int totalTest) {
        this.totalTest = totalTest;
    }

    public void setNumOfTestPass(int numOfTestPass) {
        this.numOfTestPass = numOfTestPass;
    }

    public void setNumOfTestFail(int numOfTestFail) {
        this.numOfTestFail = numOfTestFail;
    }

    public void setTestCaseFail(List<TestCaseObj> testCaseFail) {
        this.testSuite = testCaseFail;
    }

    public void setScoreOfLine(Map<SuspiciousCode, Float> scoreOfLine) {
        this.scoreOfLine = scoreOfLine;
    }

    public int getNumOfTestPass() {
        return numOfTestPass;
    }

    public int getNumOfTestFail() {
        return numOfTestFail;
    }

    public List<TestCaseObj> getTestCaseFail() {
        return testSuite;
    }

    public Map<SuspiciousCode, Float> getScoreOfLine() {
        return scoreOfLine;
    }
}
