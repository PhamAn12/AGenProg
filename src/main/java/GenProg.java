import Fitness.Fitnesser;
import GzFaulocalization.FaulFinder;
import GzFaulocalization.FaulResult;
import GzFaulocalization.Faulocalizator;
import ObjectGenProg.FileFinder;


import java.io.IOException;
import java.util.List;

public class GenProg {
    public static void MainThread() throws IOException {
        String pathToBuggyProject = "D:\\thsi\\projrepare\\hhh";
        FileFinder fileFinder = new FileFinder(pathToBuggyProject);
        String pathToclassSource = fileFinder.findClassPath();
        List<String> listTestCase = fileFinder.ListTestCasePackage();
        List<String> listBuggyPackage = fileFinder.ListBuggyPackage();
        Faulocalizator faulocalizator = new Faulocalizator(pathToclassSource,listTestCase,listBuggyPackage);
        FaulResult faulResult = faulocalizator.RankingBug();
        int numOfTestPass = faulResult.getNumOfTestPass();
        int numOfTestFail = faulResult.getNumOfTestFail();
        Fitnesser f = new Fitnesser(numOfTestPass,numOfTestFail);
        System.out.println("max point :  "+ f.getMaxPoint());
        faulResult.printResult();

//        System.out.println(pathToclassSource);
//        GZoltar gz = new GZoltar(pathToBuggyProject);
//        gz.addPackageToInstrument("Buggy2");
//        //gz.addPackageToInstrument("Buggy2");
//        gz.addTestToExecute("TestBuggy2.TestMidFuction2");
//        gz.run();
//        List<TestResult> testResults = gz.getTestResults();
//        //System.out.println(gz.getSuspiciousStatements());
//        for (Statement grozaStatement: gz.getSuspiciousStatements()) {
//            String comp = grozaStatement.getLabel();
//            String comparent = grozaStatement.getMethod().getParent().getLabel();
//            System.out.println(comp);
//            System.out.println(comparent);
//        }
    }
}
