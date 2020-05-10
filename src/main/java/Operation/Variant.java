package Operation;

import ObjectGenProg.ProjectFacade;
import spoon.reflect.CtModel;

public class Variant {
    private ProjectFacade projectFacade;

    public ProjectFacade getProjectFacade() {
        return projectFacade;
    }

    private float fitnessPoint;
    private boolean isSOL = false;

    public void setProjectFacade(ProjectFacade projectFacade) {
        this.projectFacade = projectFacade;
    }

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
