package ObjectGenProg;

import java.util.List;

public interface Filer {
    List<String> ListTestCasePackage();
    List<String> ListBuggyPackage();
    String findClassPath();
}
