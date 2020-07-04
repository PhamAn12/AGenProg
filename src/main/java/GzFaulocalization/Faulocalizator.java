package GzFaulocalization;

import com.gzoltar.core.GZoltar;
import com.gzoltar.core.components.Statement;
import com.gzoltar.core.instr.testing.TestResult;
import spoon.reflect.code.CtStatement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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
                System.out.println("PF : " + packageFolder);
                gz.addPackageToInstrument(packageFolder);
            }
            for (String testCase: listTestCase) {
                System.out.println("TC : " + testCase);
                gz.addTestToExecute(testCase);
            }
            gz.run();
            final Runnable stuffToDo = new Thread() {
                @Override
                public void run() {
                    System.out.println("Dang chay trong thread day");
                    gz.run();
                    /* Do stuff here. */
                }
            };

            final ExecutorService executor = Executors.newSingleThreadExecutor();
            final Future future = executor.submit(stuffToDo);
            executor.shutdown(); // This does not cancel the already-scheduled task.

            try {
                future.get(5, TimeUnit.SECONDS);
            }
            catch (InterruptedException ie) {
                System.out.println("INTerrupt");
                /* Handle the interruption. Or ignore it. */
            }
            catch (ExecutionException ee) {
                System.out.println("some exception");
                /* Handle the error. Or ignore it. */
            }
            catch (TimeoutException te) {
                System.out.println("some time out");
                /* Handle the timeout. Or ignore it. */
            }
            if (!executor.isTerminated())
                executor.shutdownNow(); // If you want to stop the code that hasn't finished.

            try {
                System.out.println("Sutdong dcuaodflsfhlsfhskfsf" + gz.getTestResults());
                if(gz.getTestResults() != null) {
                    List<TestResult> testResults = gz.getTestResults();
                    totalTestCase = testResults.size();
                    for (TestResult tr : testResults) {
                        TestCaseObj testCaseObj = new TestCaseObj();
                        String testName = tr.getName().split("#")[0];

                        testCaseObj.setTestCaseName(tr.getName());
                        if (!tr.wasSuccessful()) {
                            totalTestFail++;
                            //testCaseObj.setNegativeTest(true);
                        } else {
                            listTestCasePass.add(testCaseObj);
                        }
                        //System.out.println("Test name la : " + testName + tr.getName());
                        testCaseObjs.add(testCaseObj);
                    }
                    totalTestPass = totalTestCase - totalTestFail;
                    for (Statement gzoltarStatement : gz.getSuspiciousStatements()) {
                        SuspiciousCode suspiciousCode = new SuspiciousCode();
                        suspiciousCode.setClassName(gzoltarStatement.getClazz().getName());
                        suspiciousCode.setMethodName(gzoltarStatement.getMethod().getName());
                        suspiciousCode.setLineNo(gzoltarStatement.getLineNumber());
                        suspiciousCode.setSuspiciousScore(gzoltarStatement.getSuspiciousness());
                        //System.out.println("CCC : " + gzoltarStatement.getSuspiciousness());
                        listSuspiciousCode.add(suspiciousCode);

                    }
                }else{
                    System.out.println("Con card");
                }
            }
            catch (NullPointerException e){
                System.out.println("Exception in gz.run()");
                //e.printStackTrace();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new FaulResult(totalTestCase,totalTestPass,totalTestFail,testCaseObjs,listSuspiciousCode,listTestCasePass);
    }
}
