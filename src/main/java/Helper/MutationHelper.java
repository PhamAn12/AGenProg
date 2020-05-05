package Helper;

import ObjectGenProg.ProjectFacade;
import spoon.Launcher;
import spoon.MavenLauncher;
import spoon.reflect.CtModel;

public class MutationHelper {
    public CtModel BuildModel(ProjectFacade projectFacade){
        Launcher spoon = new Launcher();
        spoon.addInputResource(projectFacade.getDirPath());
        spoon.getEnvironment().setNoClasspath(true);
        spoon.buildModel();
        return spoon.getModel();

    }
    public CtModel BuildClassWithPath(String path){
        Launcher spoon = new Launcher();
        spoon.addInputResource(path);
        spoon.getEnvironment().setNoClasspath(true);
        spoon.buildModel();
        return spoon.getModel();

    }
}
