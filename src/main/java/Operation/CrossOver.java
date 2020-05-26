package Operation;

import Fitness.Fitnesser;
import GzFaulocalization.FaulResult;
import GzFaulocalization.Faulocalizator;
import GzFaulocalization.TestCaseObj;
import ObjectGenProg.FixFileFinder;
import ObjectGenProg.ProjectFacade;
import ObjectGenProg.ResultPopulation;
import ObjectGenProg.SpoonModelObj;
import Population.ConvertChildToClass;
import Population.MatingPool;
import Population.Variant;
import Population.VariantFinder;
import spoon.reflect.code.CtStatement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.random;

public class CrossOver {
    String pathToParent1 = "D:\\thsi\\src\\main\\AutoGenerateFolder\\CrosOver\\parent1.java";
    String pathToParent2 = "D:\\thsi\\src\\main\\AutoGenerateFolder\\CrosOver\\parent2.java";
    String pathToChild = "D:\\thsi\\src\\main\\AutoGenerateFolder\\CrosOver\\child.java";
    private Variant parent1;
    private Variant parent2;
    private ResultPopulation resultPopulation;
    public CrossOver(Variant parent1, Variant parent2, ResultPopulation resultPopulation) {
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.resultPopulation = resultPopulation;

    }
    public Variant DoCross () throws IOException {
        Variant childVariant = new Variant();
        Random ranFloat = new Random();
        WriteToFile(pathToParent1,parent1.getContext());
        WriteToFile(pathToParent2,parent2.getContext());
        ProjectFacade parentFacade1 = new ProjectFacade(pathToParent1);
        ProjectFacade parentFacade2 = new ProjectFacade(pathToParent2);
        ModelBuiler mb1 = new ModelBuiler(parentFacade1);
        ModelBuiler mb2 = new ModelBuiler(parentFacade2);
        List<SpoonModelObj> spoonModelObjs1 = mb1.GetModelElements();
        List<SpoonModelObj> spoonModelObjs2 = mb2.GetModelElements();
        System.out.println("dong 4 la : " + spoonModelObjs1.get(0).getStatementByLineNo(4));
        int cutoffLine = ChooseCutOff(parent1);
        System.out.println("Cutoff :  " + cutoffLine + " score : " + parent1.getWeightPath().get(cutoffLine));
        Object[] keysArrayWeightPath1 = parent1.getWeightPath().keySet().toArray();
        for(Object key : keysArrayWeightPath1) {
            //if((int)key > cutoffLine) {
                System.out.println("key la : " + key);
                float ranProb = ranFloat.nextFloat();
                System.out.println("Ran float : " + ranProb);
                System.out.println("weight of line : " + parent1.getWeightPath().get(cutoffLine) );
                if(ranProb < parent1.getWeightPath().get(cutoffLine)) {
                    System.out.println("ran float : " + ranFloat.nextFloat());
                    CtStatement sourceStatement = spoonModelObjs1.get(0).getStatementByLineNo((int)key);
                    CtStatement tempStatement2 =  spoonModelObjs2.get(0).getStatementByLineNo((int)key);
                    System.out.println("origin statemnt : " + sourceStatement);
                    if(sourceStatement != null && tempStatement2 != null) {

                        System.out.println("TEMP statement : " + tempStatement2 + "  " + key);
                        System.out.println("Statement key i : " + spoonModelObjs1.get(0).getStatementByLineNo((int)key));
                        sourceStatement.replace(tempStatement2);
                        System.out.println("child context :  " + spoonModelObjs1.get(0).getSpoonCtModel().getAllTypes());
                    }
                }
            //}
        }
        WriteToFile(pathToChild,"package Buggy2;\n" +spoonModelObjs1.get(0).getSpoonCtModel().getAllTypes().toString().substring(1,spoonModelObjs1.get(0).getSpoonCtModel().getAllTypes().toString().length()-1));
        childVariant.setContext("package Buggy2;\n" +spoonModelObjs1.get(0).getSpoonCtModel().getAllTypes().toString().substring(1,spoonModelObjs1.get(0).getSpoonCtModel().getAllTypes().toString().length()-1));
//        childVariant.setFinessScore(0.03f);
//        childVariant.setWeightPath(parent1.getWeightPath());
        SetFitnessPointAndWeightPath(childVariant);
        return childVariant;
    }
    void WriteToFile(String path,String context) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(context);
        fileWriter.close();
    }
    int ChooseCutOff(Variant variant) {
        Random random = new Random();
        Map<Integer,Double> mapWeightPath = variant.getWeightPath();
        Object[] keysArray = mapWeightPath.keySet().toArray();
        Object keyRandom = keysArray[random.nextInt(keysArray.length)];
        return (int)keyRandom;
    }
    void SetFitnessPointAndWeightPath(Variant childVariant) throws IOException {
        ConvertChildToClass convertChildToClass = new ConvertChildToClass("");
        convertChildToClass.ConvertFile();
        FixFileFinder fixFileFinder = new FixFileFinder();
        Faulocalizator faulocalizator1 = new Faulocalizator(fixFileFinder.findClassPath(),
                fixFileFinder.ListTestCasePackage(), fixFileFinder.ListBuggyPackage());
        FaulResult testCaseresult1 = faulocalizator1.RankingBug();
        VariantFinder variantFinder = new VariantFinder(testCaseresult1);
        variantFinder.AddWeightPath(childVariant);

        System.out.println("WEIGHTTTT PATHTHTHTHT : " + childVariant.getWeightPath());
        List<TestCaseObj> testCaseCurrentList = testCaseresult1.getTestPassList();
        Fitnesser ff = new Fitnesser(resultPopulation.getListTestCaseOfFirstVariant(), testCaseCurrentList);
        System.out.println("fittnesspoint la : " + ff.getFinessPoint());
        childVariant.setFinessScore(ff.getFinessPoint());
    }
}
