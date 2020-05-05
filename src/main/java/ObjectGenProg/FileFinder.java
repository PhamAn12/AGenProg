package ObjectGenProg;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileFinder implements Filer {
    private String pathToProject;
    public FileFinder(String path){
        this.pathToProject = path;
    }

    @Override
    public List<String> ListTestCasePackage() {
        String prefix = "\\src\\test\\java";
        List<String> testCaseName = new ArrayList<String>();
        try (Stream<Path> walk = Files.walk(Paths.get(pathToProject + prefix))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            for (String re : result){
                String nameOfTest = re.substring(pathToProject.length() + prefix.length() + 1);
                String testCaseMethod = nameOfTest.replace("\\",".").replace(".java","");
                testCaseName.add(testCaseMethod);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCaseName;
    }
    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }
    @Override
    public List<String> ListBuggyPackage() {
        List<String> nameOfBuggyPackage = new ArrayList<String>();
        String prefix = "\\src\\main\\java";
        File[] directories = listFileInAPath(pathToProject + prefix);
        for(File file : directories){
            System.out.println(file.getName());
            nameOfBuggyPackage.add(file.getName());
        }
        return nameOfBuggyPackage;
    }

    @Override
    public String findClassPath() {
        String prefixClassFile ="\\target\\classes";
        return pathToProject + prefixClassFile;
    }
    public File[] listFileInAPath(String path){
        File[] directories = new File(path).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        return directories;
    }
}
