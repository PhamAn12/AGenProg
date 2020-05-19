package Population;

import ObjectGenProg.ProjectFacade;
import ObjectGenProg.SpoonModelObj;
import Operation.ModelBuiler;

import java.util.ArrayList;
import java.util.List;

public class PopulationInit {
    private int numofCandidate;
    Variant firstVariant;
    public PopulationInit(int numofCandidate,Variant firstVariant) {
        this.numofCandidate = numofCandidate;
        this.firstVariant = firstVariant;
    }
    public List<Variant> GetVariantModel(){
        System.out.println(firstVariant.getPathToVariant());
        ProjectFacade projectFacade = new ProjectFacade(firstVariant.getPathToVariant());
        List<Variant> listVariant = new ArrayList<Variant>();
        ModelBuiler mb = new ModelBuiler(projectFacade);
        List<SpoonModelObj> spoonModelObjList =  mb.GetModelElements();
        //for(SpoonModelObj spoonModelObj : spoonModelObjList) {
            for(int i = 0; i < numofCandidate; i++)
            {
                Variant variant = new Variant();
                SpoonModelObj spoonModelObj = mb.GetModelElements().get(0);
                MutationController mut = new MutationController(spoonModelObj,firstVariant);
//                System.out.println("TRUOC : ");
//                spoonModelObj.printSomething();
                mut.ApplyMutation();
//                System.out.println("SAU : ");
//                spoonModelObj.printSomething();
                variant.setContext("package Buggy2;\n" + spoonModelObj.getSpoonCtModel().getAllTypes().toString().substring(1,spoonModelObj.getSpoonCtModel().getAllTypes().toString().length()-1));
                listVariant.add(variant);
            }
//            for (Integer key : firstVariant.getWeightPath().keySet()) {
//                System.out.println("all key : " + key);
//                if(firstVariant.getWeightPath().get(key) > 0) {
//                    System.out.println(spoonModelObj.getStatementByLineNo(key));
//
//                    System.out.println("specify key : " + key + " suspicious value : " + firstVariant.getWeightPath().get(key));
//                }
//            }
//            CtStatement statement6 = spoonModelObj.getStatementByLineNo(6);
//            CtStatement statement10 = spoonModelObj.getStatementByLineNo(10);
//
//            statement10.insertBefore(statement6);
        //}

        return listVariant;
    }

}
