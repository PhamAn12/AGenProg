import Fitness.FitnessControler;
import Fitness.Fitnesser;
import GzFaulocalization.*;
import Helper.MutationHelper;
import Mutation.InsertAfter;
import Mutation.MutationOpInterface;
import Mutation.ReplaceOp;
import ObjectGenProg.*;
import Operation.InsertBefore;
import Operation.ModelBuiler;
import Operation.OperationSelect;
import Population.*;
import com.gzoltar.core.GZoltar;
import com.gzoltar.core.components.Statement;
import com.gzoltar.core.instr.testing.TestResult;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenProg {
    public static void MainThread() throws IOException {
        String pathToBuggyProject = "D:\\thsi\\projrepare\\hhh";
        String pathToTest1 = "D:\\thsi\\projrepare\\hhh\\src\\test\\java\\TestBuggy\\TestMidFuction1.java";
        String pathToTest2 = "D:\\thsi\\projrepare\\hhh\\src\\test\\java\\TestBuggy2\\TestMidFuction2.java";
        List<String> pathTotestCaseFile = new ArrayList<String>();
        pathTotestCaseFile.add(pathToTest1);
        pathTotestCaseFile.add(pathToTest2);
        ProjectFacade projectFacade = new ProjectFacade(pathToBuggyProject);
        FileFinder fileFinder = new FileFinder(pathToBuggyProject);
        String pathToclassSource = fileFinder.findClassPath();
        List<String> listTestCase = fileFinder.ListTestCasePackage();
        List<String> listBuggyPackage = fileFinder.ListBuggyPackage();

        Faulocalizator faulocalizator = new Faulocalizator(pathToclassSource,listTestCase,listBuggyPackage);
        FaulResult faulResult = faulocalizator.RankingBug();

        // Test faultResult ^^
//        int numOfTestPass = faulResult.getNumOfTestPass();
//        int numOfTestFail = faulResult.getNumOfTestFail();
//        Fitnesser f = new Fitnesser(numOfTestPass,numOfTestFail);
//        System.out.println("max point :  "+ f.getMaxPoint());
//        faulResult.printResult();
//
//        ModelBuiler md = new ModelBuiler(projectFacade);
//        OperationSelect os = new OperationSelect();
//        InsertBefore ib = new InsertBefore(os,md,faulResult);
//        ib.ApplyChange();
//        modelBuiler.GetModelElements();

//
//  }}
        // Test AutoGenerateFile
        AutoAddFile autoAddFile = new AutoAddFile(faulResult);
        autoAddFile.CreateFolderForTest();
//        // copy tét class file to autogenfolder
//        for(String path : fileFinder.listTestCaseClassPath()) {
//            System.out.println("PATH: " + path);
//            autoAddFile.CreateTestClassPath(path);
//        }
        // test file finder
        //System.out.println("Tét file finder :   " + fileFinder.listTestCaseClassPath());
        // Test SpoonModelObj
//        ProjectFacade fileBuggyPath = new ProjectFacade("D:\\thsi\\src\\main\\AutoGenerateFolder\\Buggy2\\MidFuction2.java");
//
//        ModelBuiler mb = new ModelBuiler(fileBuggyPath);
//        List<SpoonModelObj> spoonModelObjList = mb.GetModelElements();
//        for(SpoonModelObj spoonModelObj : spoonModelObjList) {
//
//            spoonModelObj.printSomething();
//            CtStatement statement1 = spoonModelObj.getStatementByLineNo(9);
//            CtStatement statement2 = spoonModelObj.getStatementByLineNo(11);
//            System.out.println("stsm 9 : " + statement1);
//            System.out.println("stsm 11 : " + statement2);
//            MutationOpInterface mutationOp = new ReplaceOp();
//            mutationOp.ApplyChange(statement1,statement2);
//
//            spoonModelObj.printSomething();
////            statement2.insertBefore(statement1);
////            spoonModelObj.printSomething();
//        }
        // Test VariantFinder
//        VariantFinder variantFinder = new VariantFinder(faulResult);
//        List<Variant> listStartVariant = variantFinder.InitFirstVariant();
//        for(Variant variant : listStartVariant) {
//            PopulationInit populationInit = new PopulationInit(2,variant);
////            List<Variant> variantList = populationInit.GetVariantModel();
////            for(Variant v : variantList) {
////                v.printVariantContext();
////            }
//            FitnessControler fitnessControler = new FitnessControler(populationInit);
//            fitnessControler.GetFitnessScore();

//        }
        // Test Convert Java to Class
//        ConvertJavaToClass convertJavaToClass = new ConvertJavaToClass("D:\\thsi\\src\\main\\AutoGenerateFolder\\Buggy2\\MidFuction2.java");
//        convertJavaToClass.GetClassFile();
        // Tét gzonltar
//        GZoltar gz = new GZoltar("D:\\thsi\\src\\main\\AutoGenerateFolder\\ClassPath");
//        gz.addPackageToInstrument("Buggy2");
//        gz.addTestToExecute("TestBuggy2.TestMidFuction2");
//        gz.addTestToExecute("TestBuggy.TestMidFuction1");
//        gz.run();
//        for (Statement gzoltarStatement: gz.getSuspiciousStatements()){
//            System.out.println(gzoltarStatement);
//
//        }
//        List<TestResult> testResults = gz.getTestResults();
//        for (TestResult tr : testResults){
//            System.out.println(tr.getCoveredComponents());
//        }
        // Test FixFileFinder
//        FixFileFinder fixFileFinder = new FixFileFinder();
//        System.out.println(fixFileFinder.findClassPath());
//        System.out.println(fixFileFinder.ListTestCasePackage());
//        System.out.println(fixFileFinder.ListBuggyPackage());
//        FaulocalizatorSmall faulocalizatorSmall = new FaulocalizatorSmall(pathToclassSource,listTestCase,listBuggyPackage);
//        FaulResult testCaseresult = faulocalizatorSmall.GetTestCasePass();
//        // Test faultResult ^^
//        int numOfTestPass = testCaseresult.getNumOfTestPass();
//        int numOfTestFail = testCaseresult.getNumOfTestFail();
//        Fitnesser f = new Fitnesser(numOfTestPass,numOfTestFail);
//        System.out.println("max point :  "+ f.getMaxPoint());
//        testCaseresult.printTestcaseResult();
//
//        Faulocalizator faulocalizator1 = new Faulocalizator(pathToclassSource,listTestCase,listBuggyPackage);
//        FaulResult testCaseresult1 = faulocalizator1.RankingBug();
//        testCaseresult1.printTestPassResult();
         //test finess function
//        FixFileFinder fixFileFinder = new FixFileFinder();
//        System.out.println(fixFileFinder.findClassPath());
//        System.out.println(fixFileFinder.ListTestCasePackage());
//        System.out.println(fixFileFinder.ListBuggyPackage());
//        FaulocalizatorSmall faulocalizatorSmall = new FaulocalizatorSmall(fixFileFinder.findClassPath(),fixFileFinder.ListTestCasePackage(),fixFileFinder.ListBuggyPackage());
//        FaulResult testCaseresult = faulocalizatorSmall.GetTestCasePass();
//        // Test faultResult ^^
//        int numOfTestPass = testCaseresult.getNumOfTestPass();
//        int numOfTestFail = testCaseresult.getNumOfTestFail();
//        Fitnesser f = new Fitnesser(numOfTestPass,numOfTestFail);
//
//        System.out.println("max point :  "+ f.getMaxPoint());
//        System.out.println("orrighiin litst : ");
//        testCaseresult.printTestcaseResult();
//
//        Faulocalizator faulocalizator1 = new Faulocalizator(fixFileFinder.findClassPath(),fixFileFinder.ListTestCasePackage(),fixFileFinder.ListBuggyPackage());
//        FaulResult testCaseresult1 = faulocalizator1.RankingBug();
//        System.out.println("CUrrentt litst : ");
//        testCaseresult1.printTestPassResult();
//        List<TestCaseObj> testCaseOriginList = testCaseresult.getTestSuite();
//        List<TestCaseObj> testCaseCurrentList = testCaseresult1.getTestPassList();
//        System.out.println("LIST orighin : " + testCaseOriginList);
//        System.out.println("LIST current : " + testCaseCurrentList);
//        Fitnesser ff = new Fitnesser(testCaseOriginList,testCaseCurrentList);
//        System.out.println("fittnesspoint la : " + ff.getFinessPoint());
        // test Population init


    }

}
