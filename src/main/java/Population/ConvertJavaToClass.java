package Population;

import com.google.common.base.Charsets;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

//Save source in .java file.
//        File root = new File("/java"); // On Windows running on C:\, this is C:\java.
//        File sourceFile = new File(root, "test/MidFunction.java");
//        sourceFile.getParentFile().mkdirs();
//        Files.write(sourceFile.toPath(), source.getBytes(StandardCharsets.UTF_8));
//
//// Compile source file.
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        compiler.run(null, null, null, sourceFile.getPath());
public class ConvertJavaToClass {
    protected String pathToJavaFile;
    public ConvertJavaToClass(String pathToJavaFile) {
        this.pathToJavaFile = pathToJavaFile;


    }
    public void GetClassFile() throws IOException {
        File root = new File ("D:\\thsi\\src\\main\\AutoGenerateFolder");
        File sourceFile = new File(root,"Buggy2/MidFuction2.java");
        System.out.println("SFCOmplie : " + sourceFile.toPath());
        sourceFile.getParentFile().mkdirs();
        Files.write(sourceFile.toPath(),GetContextByPath(sourceFile.getPath()).getBytes(StandardCharsets.UTF_8));

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null,null,null,sourceFile.getPath());
        FileModifiedDir.moveFileDir("D:\\thsi\\src\\main\\AutoGenerateFolder\\Buggy2\\MidFuction2.class","D:\\thsi\\src\\main\\AutoGenerateFolder\\ClassPath\\");

    }

    public String GetContextByPath(String pathToFile) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(pathToFile), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
