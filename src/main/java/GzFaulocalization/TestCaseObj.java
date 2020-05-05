package GzFaulocalization;

public class TestCaseObj {
    private String testCaseName;
    private Boolean isNegativeTest = false;

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public void setNegativeTest(Boolean negativeTest) {
        isNegativeTest = negativeTest;
    }

    public Boolean getNegativeTest() {
        return isNegativeTest;
    }
    public void printTest(){
        System.out.println("TC : " + testCaseName + " isP : " + isNegativeTest);
    }
}
