package Fitness;

import GzFaulocalization.FaulResult;
import GzFaulocalization.Faulocalizator;
import Helper.Rater;
import Helper.TestCaseDetector;
import ObjectGenProg.TestCase;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Fitnesser {
    private int numOfTestPass;
    private int numOfTestFail;
    public Fitnesser(int numOfTestPass, int numOfTestFail){
        this.numOfTestPass = numOfTestPass;
        this.numOfTestFail = numOfTestFail;
    }
    public float getMaxPoint(){
        return Rater.setRateOfNegativeTest()* numOfTestFail + Rater.setRateOfPositiveTest()* numOfTestPass;
    }


}
