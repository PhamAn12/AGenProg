package Population;

import java.util.Dictionary;
import java.util.Map;

public class Variant {
    private String className;

    public void setFinessScore(float finessScore) {
        this.finessScore = finessScore;
    }

    public float getFinessScore() {
        return finessScore;
    }

    private float finessScore;
    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    private String functionName;
    private String context;
    private boolean isSOL = false;

    public void setClassName(String className) {
        this.className = className;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setSOL(boolean SOL) {
        isSOL = SOL;
    }

    public void setPathToVariant(String pathToVariant) {
        this.pathToVariant = pathToVariant;
    }

    public void setWeightPath(Map<Integer, Double> weightPath) {
        this.weightPath = weightPath;
    }

    public String getClassName() {
        return className;
    }

    public String getContext() {
        return context;
    }

    public boolean isSOL() {
        return isSOL;
    }

    public String getPathToVariant() {
        return pathToVariant;
    }

    public Map<Integer, Double> getWeightPath() {
        return weightPath;
    }

    private String pathToVariant;
    Map<Integer,Double> weightPath;
    public void printVariantContext () {
        System.out.println(className + " " + functionName);
        System.out.println(weightPath);
        System.out.println(context);
        System.out.println(pathToVariant);
    }
}
