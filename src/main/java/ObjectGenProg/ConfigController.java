package ObjectGenProg;

import ObjectGenProg.Configer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigController {
    public static String pathToConfigFile = "D:\\thsi\\src\\main\\java\\Config";
    public static Configer getInputParam() {
        Configer configer = new Configer();
        try {
            File myObj = new File(pathToConfigFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.startsWith("pathToBuggyProject = ")) {
                    configer.setPathToProject(data.substring(21));

                }
                else if(data.startsWith("populationSize = ")) {
                    configer.setPopulationSize(Integer.parseInt(data.substring(17)));

                }
                else if (data.startsWith("numOfGeneration = ")) {
                    configer.setNumOfGeneration(Integer.parseInt(data.substring(18)));

                }
                else if (data.startsWith("WMutationRate = ")) {
                    configer.setMutationRate(Float.parseFloat(data.substring(16)));

                }
                else if (data.startsWith("pathToTestFile = ")){
                    configer.setPathToTestFile(data.substring(17));

                }
                else if (data.startsWith("BuggyLine = ")) {
                    configer.setBuggyLine(Integer.parseInt(data.substring(12)));
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return configer;
    }
}
