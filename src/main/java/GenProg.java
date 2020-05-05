import Fitness.Fitnesser;
import GzFaulocalization.FaulFinder;
import GzFaulocalization.FaulResult;
import GzFaulocalization.Faulocalizator;
import Helper.MutationHelper;
import ObjectGenProg.FileFinder;
import ObjectGenProg.ProjectFacade;
import Operation.ModelBuiler;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;


import java.io.IOException;
import java.util.List;

public class GenProg {
    public static void MainThread() throws IOException {
        String pathToBuggyProject = "D:\\thsi\\projrepare\\hhh";
        ProjectFacade projectFacade = new ProjectFacade(pathToBuggyProject);
//        FileFinder fileFinder = new FileFinder(pathToBuggyProject);
//        String pathToclassSource = fileFinder.findClassPath();
//        List<String> listTestCase = fileFinder.ListTestCasePackage();
//        List<String> listBuggyPackage = fileFinder.ListBuggyPackage();
//        Faulocalizator faulocalizator = new Faulocalizator(pathToclassSource,listTestCase,listBuggyPackage);
//        FaulResult faulResult = faulocalizator.RankingBug();
//        int numOfTestPass = faulResult.getNumOfTestPass();
//        int numOfTestFail = faulResult.getNumOfTestFail();
//        Fitnesser f = new Fitnesser(numOfTestPass,numOfTestFail);
//        System.out.println("max point :  "+ f.getMaxPoint());
//        faulResult.printResult();
        ModelBuiler modelBuiler = new ModelBuiler(projectFacade);
        modelBuiler.GetModelElements();

//
//  }}
    }
}
