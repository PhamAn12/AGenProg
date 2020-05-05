import Fitness.Fitnesser;
import Fitness.JunitExecer;
import Fitness.TestCaseListener;
import Helper.MutationHelper;
import Helper.TestCaseDetector;
import JavaTest.TestTask;
import ObjectGenProg.TestCase;
import com.gzoltar.core.GZoltar;
import com.gzoltar.core.components.Statement;
import com.gzoltar.core.instr.testing.TestResult;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.List;
import java.util.Map;



public class mainProg {
    public static void main(String[] args) throws Exception {
//        Map<String, Map<Integer,Boolean>> a;
//
//        TestCaseDetector testCaseFinder = new TestCaseDetector();
//        List<TestCase> listTestCase = testCaseFinder.InitTestCaseObjectResult();
//        for (TestCase t : listTestCase){
//            System.out.println(t.getParam() + "\t" + t.getResultOfTest() + "\t" + t.getMethodNameTC());
//        }
//
//        List<TestCase> listTestCase1 = testCaseFinder.GetActualTestResult(new TestCaseListener());
//        for (TestCase t : listTestCase1){
//            System.out.println(t.getParam() + "\t" + t.getResultOfTest() + "\t" + t.getMethodNameTC());
//        }
//        Fitnesser f = new Fitnesser();
//        System.out.println("DFDFDF : " + f.getMaxPoint());

//        MutationHelper mutationHelper = new MutationHelper();
//        String pathToTestFile = "D:\\docu\\thsi\\src\\main\\java\\Task\\Task1.java";
//        CtModel testCaseFileModel = mutationHelper.BuildClassWithPath(pathToTestFile);
//
//        List<CtMethod> allMethods = testCaseFileModel.getElements(new TypeFilter<>(CtMethod.class));
//        System.out.println("size method : " + allMethods.size());
//        for (CtMethod<?> myMethod : allMethods) {
//            CtBlock ctBlock = myMethod.getBody();
//            CtStatement ctStatement1 = ctBlock.getStatement(5);
////            CtStatement ctStatement2 = ctBlock.getStatement(5);
////            CtStatement ctStatement = (CtStatement) ctStatement2.getParent();
////            //ctStatement1.insertAfter(ctStatement2);
//            System.out.println(ctStatement1);
//            CtBlock blockStatement = (CtBlock) ctStatement1.getParent();
////            System.out.println("ststm 2 : " + ctBlock);
////            System.out.println(statement);
//            //System.out.println("ss : "+myMethod.getBody().getStatements().get(1));
//            CtIf ifStament =(CtIf) myMethod.getBody().getStatements().get(1);
//            System.out.println("if stat : " + ifStament.getOriginalSourceFragment());
//
//        }
//        testCaseFinder.GetActualTestResult(TestTask.class,new TestCaseListener());


//        JUnitCore runner = new JUnitCore();
//        runner.addListener(new TextListener(System.out));
//        Request request = Request.method(TestTask.class,"mid_test_1");
//        runner.run(request);


//        TestCaseDetector testCaseDetector = new TestCaseDetector();
//        testCaseDetector.GetActualTestResult(new TestCaseListener());
        //testCaseDetector.getAllMethodNameOfTestCaseClass("D:\\docu\\thsi\\src\\main\\java\\JavaTest\\TestTask.java");
//        String classPath = "D:\\docu\\thsi\\projrepare\\v1\\target\\classes";
//        GZoltar gz = new GZoltar(classPath);
//        //gz.addClassToInstrument("D:\\docu\\thsi\\projrepare\\v1\\target\\classes\\junit\\util\\MidFunction.class");
//        gz.addPackageToInstrument("test");
//        gz.addTestToExecute("junit.util.MidFunctionTest");
//        gz.run();
//        List<TestResult> testResults = gz.getTestResults();
//        //System.out.println(gz.getSuspiciousStatements());
//        for (Statement grozaStatement: gz.getSuspiciousStatements()) {
//            String comp = grozaStatement.getLabel();
//            String comparent = grozaStatement.getMethod().getParent().getLabel();
//            System.out.println(comp);
//            System.out.println(comparent);
//        }
        GenProg.MainThread();

    }

}
