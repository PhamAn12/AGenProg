package ObjectGenProg;

import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtPackage;

import java.util.List;

public class ProjectFacade {
    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }

    public String getDirPath() {
        return dirPath;
    }
    public ProjectFacade(String dirPath){
        this.dirPath = dirPath;
    }
    String dirPath;

    public List<CtPackage> listPackage (CtModel modelProject) {
        return null;
    }
}
