package Population;

import Fitness.Fitnesser;
import GzFaulocalization.FaulResult;
import GzFaulocalization.Faulocalizator;
import GzFaulocalization.FaulocalizatorSmall;
import GzFaulocalization.TestCaseObj;
import ObjectGenProg.FixFileFinder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AutoAddFile {
    private FaulResult faulResult;

    public AutoAddFile(FaulResult faulResult) {
        this.faulResult = faulResult;
    }

    String desPathForTest = "D:\\thsi\\src\\main\\AutoGenerateFolder\\";

    public void CreateFolderForTest() throws IOException {
        VariantFinder vf = new VariantFinder(faulResult);
        //System.out.println(vf.GetContextOfVariant(GetBuggyPathFile.GetAbsolutePath("Buggy2.MidFuction2")));
        List<Variant> lv = vf.InitFirstVariant();
        for (Variant variant : lv) {
            System.out.println("CLLLLASSSS name : " + variant.getClassName());
            System.out.println("Path to the nngn : " + variant.getPathToVariant());
            FileModifiedDir.moveFileDir(variant.getPathToVariant(), desPathForTest);
            String pathToNewBuggyFile = desPathForTest + variant.getClassName().replace(".", "\\") + ".java";
            System.out.println("patho to buggy file : " + pathToNewBuggyFile);
            PopulationInit populationIniter = new PopulationInit(2, variant);
            List<Variant> listGenerateVariant = populationIniter.GetVariantModel();
            for (Variant vari : listGenerateVariant) {
                System.out.println(vari.getContext());
                FileWriter fileWriter = new FileWriter(pathToNewBuggyFile);
                fileWriter.write(vari.getContext());
                fileWriter.close();
                ConvertJavaToClass convertJavaToClass = new ConvertJavaToClass(pathToNewBuggyFile);
                convertJavaToClass.GetClassFile();


                FixFileFinder fixFileFinder = new FixFileFinder();
                System.out.println(fixFileFinder.findClassPath());
                System.out.println(fixFileFinder.ListTestCasePackage());
                System.out.println(fixFileFinder.ListBuggyPackage());
                FaulocalizatorSmall faulocalizatorSmall = new FaulocalizatorSmall(fixFileFinder.findClassPath(), fixFileFinder.ListTestCasePackage(), fixFileFinder.ListBuggyPackage());
                FaulResult testCaseresult = faulocalizatorSmall.GetTestCasePass();
                // Test faultResult ^^
                int numOfTestPass = testCaseresult.getNumOfTestPass();
                int numOfTestFail = testCaseresult.getNumOfTestFail();
                Fitnesser f = new Fitnesser(numOfTestPass, numOfTestFail);

                System.out.println("max point :  " + f.getMaxPoint());
                System.out.println("orrighiin litst : ");
                testCaseresult.printTestcaseResult();

                Faulocalizator faulocalizator1 = new Faulocalizator(fixFileFinder.findClassPath(), fixFileFinder.ListTestCasePackage(), fixFileFinder.ListBuggyPackage());
                FaulResult testCaseresult1 = faulocalizator1.RankingBug();
                System.out.println("CUrrentt litst : ");
                testCaseresult1.printTestPassResult();
                List<TestCaseObj> testCaseOriginList = testCaseresult.getTestSuite();
                List<TestCaseObj> testCaseCurrentList = testCaseresult1.getTestPassList();
                System.out.println("LIST orighin : " + testCaseOriginList);
                System.out.println("LIST current : " + testCaseCurrentList);
                Fitnesser ff = new Fitnesser(testCaseOriginList, testCaseCurrentList);
                System.out.println("fittnesspoint la : " + ff.getFinessPoint());

            }

        }
    }

    public void CreateFolderTest(String pathToTestCase) {
        FileModifiedDir.moveFileDir(pathToTestCase, desPathForTest);
    }

    public void CreateTestClassPath(String pathToCopyFile) {
        String prefix = "ClassPath\\";
        FileModifiedDir.moveFileDir(pathToCopyFile, desPathForTest + prefix);
    }

}
