package ObjectGenProg;

public class Configer {
    private String pathToProject;
    private int populationSize;

    public String getPathToTestFile() {
        return pathToTestFile;
    }

    public void setPathToTestFile(String pathToTestFile) {
        this.pathToTestFile = pathToTestFile;
    }

    private int numOfGeneration;
    private float mutationRate;

    public int getBuggyLine() {
        return buggyLine;
    }

    public void setBuggyLine(int buggyLine) {
        this.buggyLine = buggyLine;
    }

    private String pathToTestFile;
    private int buggyLine;
    public String getPathToProject() {
        return pathToProject;
    }

    public void setPathToProject(String pathToProject) {
        this.pathToProject = pathToProject;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public int getNumOfGeneration() {
        return numOfGeneration;
    }

    public void setNumOfGeneration(int numOfGeneration) {
        this.numOfGeneration = numOfGeneration;
    }

    public float getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(float mutationRate) {
        this.mutationRate = mutationRate;
    }
    public void printsmst () {
        System.out.println("Path :" + pathToProject + "pop size :" + populationSize + "MutRate :" + mutationRate );
    }
}
