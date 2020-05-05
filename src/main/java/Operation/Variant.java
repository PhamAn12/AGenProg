package Operation;

import spoon.reflect.CtModel;

public class Variant {
    private float fitnessPoint;
    private boolean isSOL = false;

    public CtModel getVariantModel() {
        return variantModel;
    }

    public void setVariantModel(CtModel variantModel) {
        this.variantModel = variantModel;
    }

    Variant parentGeneration;
    CtModel variantModel;
    public boolean isSOL() {
        return isSOL;
    }

    public void setSOL(boolean SOL) {
        isSOL = SOL;
    }

    public float getFitness() {
        return fitnessPoint;
    }

    public void setFitness(float fitness) {
        this.fitnessPoint = fitness;
    }

}
