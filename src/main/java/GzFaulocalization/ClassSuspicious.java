package GzFaulocalization;

import ObjectGenProg.FileFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassSuspicious extends SuspiciousCode{
    private String contextOfBuggyFile;
    private String pathToBuggyFile;
    public ClassSuspicious(String pathToBuggyFile) {
        this.pathToBuggyFile = pathToBuggyFile;
    }

    public String getContextOfBuggyFile() {
        Path path = Paths.get(pathToBuggyFile);
        String contextFile ="";
        try {
            contextFile = Files.readAllLines(path).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contextFile;
    }
}
