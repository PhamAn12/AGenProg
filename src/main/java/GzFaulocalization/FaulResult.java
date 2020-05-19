package GzFaulocalization;

import ObjectGenProg.TestCase;

import java.util.List;
import java.util.Map;

public class FaulResult {
    private int totalTest;
    private int numOfTestPass;
    private int numOfTestFail;

    public void setTestSuite(List<TestCaseObj> testSuite) {
        this.testSuite = testSuite;
    }

    List<TestCaseObj> testSuite;

    public List<TestCaseObj> getTestSuite() {
        return testSuite;
    }

    public List<TestCaseObj> getTestPassList() {
        return testPassList;
    }

    public void setTestPassList(List<TestCaseObj> testPassList) {
        this.testPassList = testPassList;
    }

    List<TestCaseObj> testPassList;
    public List<SuspiciousCode> getListSuspiciousCode() {
        return listSuspiciousCode;
    }

    public void setListSuspiciousCode(List<SuspiciousCode> listSuspiciousCode) {
        this.listSuspiciousCode = listSuspiciousCode;
    }

    Map<SuspiciousCode, Float> scoreOfLine;
    List<SuspiciousCode> listSuspiciousCode;
    public FaulResult(int totalTest, int numOfTestPass, int numOfTestFail,List<TestCaseObj> testSuite,
                      List<SuspiciousCode> listSuspiciousCode,List<TestCaseObj> listPassTest) {
        this.totalTest = totalTest;
        this.numOfTestPass = numOfTestPass;
        this.numOfTestFail = numOfTestFail;
        this.listSuspiciousCode = listSuspiciousCode;
        this.testSuite = testSuite;
        this.testPassList = listPassTest;

    }
    public FaulResult(List<TestCaseObj> testCaseObjList, int numOfTestFail, int numOfTestPass) {
        this.testSuite = testCaseObjList;
        this.numOfTestFail = numOfTestFail;
        this.numOfTestPass = numOfTestPass;
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
    public void printTestcaseResult(){
        for(TestCaseObj testCaseObj : testSuite){
            testCaseObj.printTest();
        }
    }
    public void printTestPassResult() {
        for (TestCaseObj testCaseObj : testPassList){
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
