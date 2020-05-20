package Operation;

import ObjectGenProg.ProjectFacade;
import ObjectGenProg.SpoonModelObj;
import Population.Variant;

import java.util.List;

public class OpLooper {
    private ProjectFacade fileFacade;
    private Variant variant;
    public OpLooper(ProjectFacade fileFacade) {
        this.fileFacade = fileFacade;
    }
    public void RunLoop(){
        ModelBuiler mb = new ModelBuiler(fileFacade);
        List<SpoonModelObj> spoonModelObjs = mb.GetModelElements();

    }
}
