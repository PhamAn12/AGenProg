import Fitness.Fitnesser;
import GzFaulocalization.FaulFinder;
import GzFaulocalization.FaulResult;
import GzFaulocalization.Faulocalizator;
import Helper.MutationHelper;
import Mutation.InsertAfter;
import Mutation.MutationOpInterface;
import Mutation.ReplaceOp;
import ObjectGenProg.FileFinder;
import ObjectGenProg.GetBuggyPathFile;
import ObjectGenProg.ProjectFacade;
import ObjectGenProg.SpoonModelObj;
import Operation.InsertBefore;
import Operation.ModelBuiler;
import Operation.OperationSelect;
import Population.AutoAddFile;
import Population.PopulationInit;
import Population.Variant;
import Population.VariantFinder;
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
//        AutoAddFile autoAddFile = new AutoAddFile(faulResult);
//        autoAddFile.CreateFolderForTest();
//        for(String path : pathTotestCaseFile) {
//            autoAddFile.CreateFolderTest(path);
//        }
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
        VariantFinder variantFinder = new VariantFinder(faulResult);
        List<Variant> listStartVariant = variantFinder.InitFirstVariant();
        for(Variant variant : listStartVariant) {
            PopulationInit populationInit = new PopulationInit(1,variant);
            populationInit.GetVariantModel();

        }
    }
}
