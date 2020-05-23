package ObjectGenProg;

import GzFaulocalization.TestCaseObj;
import Population.Variant;

import java.util.List;

public class ResultPopulation {
    private float maxFitnessScore;
    private List<TestCaseObj> listTestCaseOfFirstVariant;
    private List<Variant> variantList;
    public ResultPopulation(float maxFitnessScore, List<TestCaseObj> listTestCaseOfFirstVariant,
    List<Variant> variantList) {
        this.maxFitnessScore = maxFitnessScore;
        this.listTestCaseOfFirstVariant = listTestCaseOfFirstVariant;
        this.variantList = variantList;
    }

    public void setMaxFitnessScore(float maxFitnessScore) {
        this.maxFitnessScore = maxFitnessScore;
    }

    public void setListTestCaseOfFirstVariant(List<TestCaseObj> listTestCaseOfFirstVariant) {
        this.listTestCaseOfFirstVariant = listTestCaseOfFirstVariant;
    }

    public void setVariantList(List<Variant> variantList) {
        this.variantList = variantList;
    }

    public float getMaxFitnessScore() {
        return maxFitnessScore;
    }

    public List<TestCaseObj> getListTestCaseOfFirstVariant() {
        return listTestCaseOfFirstVariant;
    }

    public List<Variant> getVariantList() {
        return variantList;
    }
}
