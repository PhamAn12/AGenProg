package Helper;

import Fitness.JunitExecer;
import Fitness.TestCaseListener;
import JavaTest.TestTask;
import ObjectGenProg.TestCase;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.visitor.filter.TypeFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class TestCaseDetector {
    public List<TestCase> InitTestCaseObjectResult() {
        String pathToTestFile = "D:\\docu\\thsi\\src\\main\\java\\JavaTest\\Testcase.txt";
        String jUnitTestCase = "D:\\docu\\thsi\\src\\main\\java\\JavaTest\\TestTask.java";
        List<String> stringMethodNameTestCaseList = getAllMethodNameOfTestCaseClass(jUnitTestCase);
        List<TestCase> testCaseResultList = new ArrayList<>();
        File testCaseResultFile = new File(pathToTestFile);
        try {
            Scanner myScanner = new Scanner(testCaseResultFile);
            int i = 0;
            while (myScanner.hasNextLine()){
                String line1 = myScanner.nextLine();
                TestCase testCaseResult = new TestCase();
                testCaseResult.setParam(new ArrayList<String>(Arrays.asList(line1.split(","))));
                String line2 = myScanner.nextLine();
                if(line2.equals("F") || line2.equals("F\n")){
                    testCaseResult.setResultOfTest(false);
                }
                else if (line2.equals("P") || line2.equals("P\n")){
                    testCaseResult.setResultOfTest(true);
                }
                testCaseResult.setMethodNameTC(stringMethodNameTestCaseList.get(i));
                testCaseResultList.add(testCaseResult);
                i = i +1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(String strMethod : stringMethodNameTestCaseList) {

        }
        return testCaseResultList;
    }
    public List<String> getAllMethodNameOfTestCaseClass(String pathToTestFile){
        MutationHelper mutationHelper = new MutationHelper();
        CtModel testCaseFileModel = mutationHelper.BuildClassWithPath(pathToTestFile);
        List<CtMethod> allMethods = testCaseFileModel.getElements(new TypeFilter<>(CtMethod.class));
        List<String> stringMethodNameList = new ArrayList<String>();
        for (CtMethod<?> myMethod : allMethods) {
            System.out.println(myMethod.getSimpleName());
            stringMethodNameList.add(myMethod.getSimpleName());
        }
        return stringMethodNameList;
    }
    public List<TestCase> GetActualTestResult(TestCaseListener listener) throws ExecutionException, InterruptedException {
        List<TestCase> listActualTestCaseResult = new ArrayList<TestCase>();
        String jUnitTestCase = "D:\\docu\\thsi\\src\\main\\java\\JavaTest\\TestTask.java";
        JunitExecer junitExecer = new JunitExecer();
        List<String> stringMethodNameTestCaseList = getAllMethodNameOfTestCaseClass(jUnitTestCase);
        // chay tung testcase voi dau vao la ten method
        for(String strMethod : stringMethodNameTestCaseList){
            TestCase testCase = new TestCase();
            Result testResult = junitExecer.process(listener,strMethod);
            System.out.println("TTTTT : " + testResult.getFailures());
            testCase.setMethodNameTC(strMethod);
            if (testResult.getFailures().size() == 0) {
                testCase.setResultOfTest(true);
            }
            else {
                testCase.setResultOfTest(false);
                testCase.setNegativeEffect(true);
            }
            listActualTestCaseResult.add(testCase);
            //System.out.println("Test case tong : " + listener.GetTestCaseFailSize());
        }


        return listActualTestCaseResult;

    }
}
