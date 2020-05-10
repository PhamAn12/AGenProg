package ObjectGenProg;

public class GetBuggyPathFile{
    public static String pathToProject = "D:\\thsi\\projrepare\\hhh";
    public static String GetAbsolutePath(String className) {
        String reformatBuggyClassName = className.replace(".","\\") + ".java";
        String prefix = "\\src\\main\\java\\";
        return pathToProject + prefix + reformatBuggyClassName;
    }
}
