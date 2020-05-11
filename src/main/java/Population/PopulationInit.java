package Population;

import ObjectGenProg.ProjectFacade;
import ObjectGenProg.SpoonModelObj;
import Operation.ModelBuiler;
import spoon.reflect.code.CtStatement;

import java.util.List;

public class PopulationInit {
    private int numofCandidate;
    Variant firstVariant;
    public PopulationInit(int numofCandidate,Variant firstVariant) {
        this.numofCandidate = numofCandidate;
        this.firstVariant = firstVariant;
    }
    public void GetVariantModel(){
        System.out.println(firstVariant.getPathToVariant());
        ProjectFacade projectFacade = new ProjectFacade(firstVariant.getPathToVariant());

        ModelBuiler mb = new ModelBuiler(projectFacade);
        List<SpoonModelObj> spoonModelObjList =  mb.GetModelElements();
        for(SpoonModelObj spoonModelObj : spoonModelObjList) {
            for (Integer key : firstVariant.getWeightPath().keySet()) {
                System.out.println("all key : " + key);
                if(firstVariant.getWeightPath().get(key) > 0) {
                    System.out.println(spoonModelObj.getStatementByLineNo(key));

                    System.out.println("specify key : " + key + " suspicious value : " + firstVariant.getWeightPath().get(key));
                }
            }
            CtStatement statement6 = spoonModelObj.getStatementByLineNo(6);
            CtStatement statement10 = spoonModelObj.getStatementByLineNo(10);
            statement10.insertBefore(statement6);
        }
    }
}
