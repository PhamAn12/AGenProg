package ObjectGenProg;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FixFileFinder implements Filer {
    String pathFixed = "D:\\thsi\\src\\main\\AutoGenerateFolder\\";
    @Override
    public List<String> ListTestCasePackage() {
        String prefix = "ClassPath";
        List<String> testCaseName = new ArrayList<String>();
        try (Stream<Path> walk = Files.walk(Paths.get(pathFixed + prefix))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            for (String re : result){

                String nameOfTest = re.substring(pathFixed.length() + prefix.length() + 1);
                if(!nameOfTest.startsWith("Test"))
                    continue;
                String testCaseMethod = nameOfTest.replace("\\",".").replace(".class","");
                testCaseName.add(testCaseMethod);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCaseName;
    }

    @Override
    public List<String> ListBuggyPackage() {
        List<String> nameOfBuggyPackage = new ArrayList<String>();
        String prefix = "ClassPath";
        File[] directories = listFileInAPath(pathFixed + prefix);
        for(File file : directories){
            System.out.println(file.getName());
            if(!file.getName().startsWith("Test"))
                nameOfBuggyPackage.add(file.getName());
        }
        return nameOfBuggyPackage;
    }

    @Override
    public String findClassPath() {
        return pathFixed + "ClassPath\\";
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
    public String rootPackage() {
        return pathFixed;
    }
}
