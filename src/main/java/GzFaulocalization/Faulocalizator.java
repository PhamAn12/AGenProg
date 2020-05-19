package GzFaulocalization;

import com.gzoltar.core.GZoltar;
import com.gzoltar.core.components.Statement;
import com.gzoltar.core.instr.testing.TestResult;
import spoon.reflect.code.CtStatement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Faulocalizator {
    protected String pathToClassSource;
    protected List<String> listTestCase;
    protected List<String> listToBuggyPackage;
    public Faulocalizator(String pathToClassSource,List<String> listTestCase,List<String> listToBuggyPackage) {
        this.pathToClassSource = pathToClassSource;
        this.listTestCase = listTestCase;
        this.listToBuggyPackage = listToBuggyPackage;
    }

    public String getPathToClassSource() {
        return pathToClassSource;
    }

    public List<String> getListTestCase() {
        return listTestCase;
    }

    public List<String> getListToBuggyPackage() {
        return listToBuggyPackage;
    }

    public void setPathToClassSource(String pathToClassSource) {
        this.pathToClassSource = pathToClassSource;
    }

    public void setListTestCase(List<String> listTestCase) {
        this.listTestCase = listTestCase;
    }

    public void setListToBuggyPackage(List<String> listToBuggyPackage) {
        this.listToBuggyPackage = listToBuggyPackage;
    }
    public FaulResult RankingBug() {
        List<SuspiciousCode> listSuspiciousCode = new ArrayList<SuspiciousCode>();
        List<TestCaseObj> testCaseObjs = new ArrayList<TestCaseObj>();
        List<TestCaseObj> listTestCasePass = new ArrayList<>();
        int totalTestCase = 0;
        int totalTestPass = 0;
        int totalTestFail = 0;
        try {
            GZoltar gz = new GZoltar(pathToClassSource);
            for (String packageFolder : listToBuggyPackage) {
                System.out.println("Package folder : " + packageFolder);
                gz.addPackageToInstrument(packageFolder);
            }
            for (String testCase: listTestCase) {
                System.out.println("tét case : " + testCase);
                gz.addTestToExecute(testCase);
            }
            gz.run();
            List<TestResult> testResults = gz.getTestResults();
            totalTestCase = testResults.size();
            for (TestResult tr : testResults) {
                TestCaseObj testCaseObj = new TestCaseObj();
                String testName = tr.getName().split("#")[0];

                testCaseObj.setTestCaseName(tr.getName());
                if(!tr.wasSuccessful()){
                    totalTestFail ++;
                    //testCaseObj.setNegativeTest(true);
                }
                else {
                    listTestCasePass.add(testCaseObj);
                }
                //System.out.println("Test name la : " + testName + tr.getName());
                testCaseObjs.add(testCaseObj);
            }
            totalTestPass = totalTestCase - totalTestFail;
            for (Statement gzoltarStatement: gz.getSuspiciousStatements()){
                SuspiciousCode suspiciousCode = new SuspiciousCode();
                suspiciousCode.setClassName(gzoltarStatement.getClazz().getName());
                suspiciousCode.setMethodName(gzoltarStatement.getMethod().getName());
                suspiciousCode.setLineNo(gzoltarStatement.getLineNumber());
                suspiciousCode.setSuspiciousScore(gzoltarStatement.getSuspiciousness());
                listSuspiciousCode.add(suspiciousCode);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FaulResult(totalTestCase,totalTestPass,totalTestFail,testCaseObjs,listSuspiciousCode,listTestCasePass);
    }
}
