package Population;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ConvertChildToClass extends ConvertJavaToClass {
    public ConvertChildToClass(String pathToJavaFile) {
        super(pathToJavaFile);
    }
    public void ConvertFile() throws IOException {
        FileModifiedDir.moveRawFileDir("D:\\thsi\\src\\main\\AutoGenerateFolder\\CrosOver\\child.java",
                "D:\\thsi\\src\\main\\AutoGenerateFolder\\Buggy2\\MidFuction2.java");
        GetClassFile();
    }
}
