package GzFaulocalization;

import com.gzoltar.core.GZoltar;
import com.gzoltar.core.components.Statement;
import com.gzoltar.core.instr.testing.TestResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FaulocalizatorSmall extends Faulocalizator {
    public FaulocalizatorSmall(String pathToClassSource, List<String> listTestCase, List<String> listToBuggyPackage) {
        super(pathToClassSource, listTestCase, listToBuggyPackage);
    }
    public FaulResult GetTestCaseList() {
        List<TestCaseObj> testCaseList = new ArrayList<>();
        int totalTestCase = 0;
        int totalTestPass = 0;
        int totalTestFail = 0;
        int totalTestNotCoverage = 0;
        try {
            GZoltar gz = new GZoltar(pathToClassSource);
            for (String packageFolder : listToBuggyPackage) {
                System.out.println("Package folder : " + packageFolder);
                gz.addPackageToInstrument(packageFolder);
            }
            for (String testCase: listTestCase) {
                System.out.println("tét case : " + testCase);
                gz.addTestToExecute(testCase);
                System.out.println("tét case luc sau : " + testCase);
            }
            //gz.run();
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

            List<TestResult> testResults = gz.getTestResults();
            totalTestCase = testResults.size();
            for (TestResult tr : testResults) {
                TestCaseObj testCaseObj = new TestCaseObj();
                String testName = tr.getName().split("#")[0];

                testCaseObj.setTestCaseName(tr.getName());
                if(!tr.wasSuccessful() && tr.getCoveredComponents().size() > 0){
                    testCaseObj.setNegativeTest(true);
                    totalTestFail ++;
                }
                if(tr.getCoveredComponents().size() > 0 ) {
                    testCaseList.add(testCaseObj);

                }
                else {
                    totalTestNotCoverage++;
                }

            }

            totalTestPass = totalTestCase - totalTestFail - totalTestNotCoverage;
            System.out.println("P : " + totalTestPass);
            System.out.println("F : " + totalTestFail);
            System.out.println("NC : " + totalTestNotCoverage);
            System.out.println("TT : " + totalTestCase );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FaulResult(testCaseList,totalTestFail,totalTestPass);
    }
}
