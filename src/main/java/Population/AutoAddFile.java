package Population;

import Fitness.Fitnesser;
import GzFaulocalization.FaulResult;
import GzFaulocalization.Faulocalizator;
import GzFaulocalization.FaulocalizatorSmall;
import GzFaulocalization.TestCaseObj;
import ObjectGenProg.ConfigController;
import ObjectGenProg.FixFileFinder;
import ObjectGenProg.ResultPopulation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoAddFile {
    private FaulResult faulResult;

    public AutoAddFile(FaulResult faulResult) {
        this.faulResult = faulResult;
    }

    String desPathForTest = "D:\\thsi\\src\\main\\AutoGenerateFolder\\";
    public List<TestCaseObj> GetOriginTestCase() throws IOException {
        VariantFinder vf = new VariantFinder(faulResult);
        List<Variant> listGenerateVariant = new ArrayList<Variant>();
        List<Variant> lv = vf.InitFirstVariant();
        List<TestCaseObj> testCaseOriginList = new ArrayList<>();
        for (Variant variant : lv) {
            System.out.println("CLLLLASSSS name : " + variant.getClassName());
            System.out.println("Path to the nngn : " + variant.getPathToVariant());
            FileModifiedDir.moveFileDir(variant.getPathToVariant(), desPathForTest);
            String pathToNewBuggyFile = desPathForTest + variant.getClassName().replace(".", "\\") + ".java";
            System.out.println("patho to buggy file : " + pathToNewBuggyFile);
            ConvertJavaToClass convertJavaToClass = new ConvertJavaToClass(pathToNewBuggyFile);
            convertJavaToClass.GetClassFile();
            FixFileFinder fixFileFinder = new FixFileFinder();
            System.out.println(fixFileFinder.findClassPath());
            System.out.println(fixFileFinder.ListTestCasePackage());
            System.out.println(fixFileFinder.ListBuggyPackage());

            FaulocalizatorSmall faulocalizatorSmall = new FaulocalizatorSmall(fixFileFinder.findClassPath(), fixFileFinder.ListTestCasePackage(), fixFileFinder.ListBuggyPackage());
            FaulResult testCaseresult = faulocalizatorSmall.GetTestCaseList();
            // origin list result test case
            testCaseOriginList = testCaseresult.getTestSuite();
        }
        return testCaseOriginList;
    }
    public ResultPopulation CreateFolderForTest() throws IOException {
        float maxScoreFitness = 0;
        List<TestCaseObj> testCaseOriginList = new ArrayList<>();
        VariantFinder vf = new VariantFinder(faulResult);
        List<Variant> listGenerateVariant = new ArrayList<Variant>();
        List<Variant> lv = vf.InitFirstVariant();
        for (Variant variant : lv) {
            System.out.println("CLLLLASSSS name : " + variant.getClassName());
            System.out.println("Path to the nngn : " + variant.getPathToVariant());
            FileModifiedDir.moveFileDir(variant.getPathToVariant(), desPathForTest);
            String pathToNewBuggyFile = desPathForTest + variant.getClassName().replace(".", "\\") + ".java";
            System.out.println("patho to buggy file : " + pathToNewBuggyFile);
            ConvertJavaToClass convertJavaToClass = new ConvertJavaToClass(pathToNewBuggyFile);
            convertJavaToClass.GetClassFile();
            FixFileFinder fixFileFinder = new FixFileFinder();
            System.out.println(fixFileFinder.findClassPath());
            System.out.println(fixFileFinder.ListTestCasePackage());
            System.out.println(fixFileFinder.ListBuggyPackage());

            FaulocalizatorSmall faulocalizatorSmall = new FaulocalizatorSmall(fixFileFinder.findClassPath(), fixFileFinder.ListTestCasePackage(), fixFileFinder.ListBuggyPackage());
            FaulResult testCaseresult = faulocalizatorSmall.GetTestCaseList();
            // origin list result test case
            testCaseOriginList = testCaseresult.getTestSuite();
            int numOfTestPass = testCaseresult.getNumOfTestPass();
            int numOfTestFail = testCaseresult.getNumOfTestFail();
            System.out.println("Test pass : " + numOfTestPass + "Test faild : " + numOfTestFail);


            Fitnesser f = new Fitnesser(numOfTestPass, numOfTestFail);

            System.out.println("max point :  " + f.getMaxPoint());
            maxScoreFitness = f.getMaxPoint();
            System.out.println("orrighiin litst : ");
            testCaseresult.printTestcaseResult();
            PopulationInit populationIniter = new PopulationInit(ConfigController.getInputParam().getPopulationSize(), variant);
            listGenerateVariant = populationIniter.GetVariantModel();
            for (Variant vari : listGenerateVariant) {
                //System.out.println( "context of varrian ttt : " + vari.getContext());
                FileWriter fileWriter = new FileWriter(pathToNewBuggyFile);
                fileWriter.write(vari.getContext());
                fileWriter.close();
                ConvertJavaToClass convertJavaToClassAfter = new ConvertJavaToClass(pathToNewBuggyFile);
                convertJavaToClassAfter.GetClassFile();

                Faulocalizator faulocalizator1 = new Faulocalizator(fixFileFinder.findClassPath(), fixFileFinder.ListTestCasePackage(), fixFileFinder.ListBuggyPackage());
                FaulResult testCaseresult1 = faulocalizator1.RankingBug();
                VariantFinder variantFinder = new VariantFinder(testCaseresult1);
                variantFinder.AddWeightPath(vari);
                System.out.println("WWeitht path : " + vari.getWeightPath());
//                System.out.println("CUrrentt litst : ");
//                testCaseresult1.printTestPassResult();

                List<TestCaseObj> testCaseCurrentList = testCaseresult1.getTestPassList();
                Fitnesser ff = new Fitnesser(testCaseOriginList, testCaseCurrentList);
                System.out.println("fittnesspoint la : " + ff.getFinessPoint());
                vari.setFinessScore(ff.getFinessPoint());
                if(ff.getFinessPoint() == maxScoreFitness) {
                    System.out.println("Soulutrion found !");
                    System.out.println(vari.getContext());
                    return new ResultPopulation(-1, testCaseOriginList,listGenerateVariant);
                }
            }

        }

        return new ResultPopulation(maxScoreFitness,testCaseOriginList,listGenerateVariant);
    }

    public void CreateFolderTest(String pathToTestCase) {
        FileModifiedDir.moveFileDir(pathToTestCase, desPathForTest);
    }

    public void CreateTestClassPath(String pathToCopyFile) {
        String prefix = "ClassPath\\";
        FileModifiedDir.moveFileDir(pathToCopyFile, desPathForTest + prefix);
    }

}
