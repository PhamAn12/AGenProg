package Fitness;
import ObjectGenProg.TestCase;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.util.Collection;
import java.util.List;

public class TestCaseListener extends RunListener {
    private long startTime;
    private long endTime;

    /**
     * Called before any tests have been run.
     */
    @Override
    public void testRunStarted(Description description) throws java.lang.Exception {
        System.out.println("Tests started! Number of tests to execute : " + description.testCount());
        startTime = System.currentTimeMillis();
    }

    /**
     * Called when all tests have finished
     */
    @Override
    public void testRunFinished(Result result) throws java.lang.Exception {
        System.out.println("Tests finished! Number of tests executed: " + result.getRunCount());
        TestCase t = new TestCase();


        endTime = System.currentTimeMillis();
        long elapsedMiliSeconds = endTime - startTime;
        System.out.println("Elapsed time of tests execution: " + elapsedMiliSeconds + " milliseconds");
    }
    @Override
    public void testFailure(Failure failure) throws java.lang.Exception {
        Description description = failure.getDescription();
        System.out.println(String.format("Execution of test case failed : %s('%s')",
                failure.getDescription(), failure.getMessage()));
        TestCase testCase = new TestCase();
        testCase.setMethodNameTC(failure.getDescription().getMethodName());
        failedTests.add(testCase);
    }
    public int GetTestCaseFailSize(){
        return failedTests.size();
    }
    private List<TestCase> testCases;
    private List<TestCase> failedTests;
}
