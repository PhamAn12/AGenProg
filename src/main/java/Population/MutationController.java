package Population;

import Mutation.MutationOpInterface;
import Mutation.OperationRamdomer;
import ObjectGenProg.SpoonModelObj;
import spoon.reflect.code.CtStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MutationController {
    private SpoonModelObj spoonModelObj ;
    private Variant variant;
    public MutationController(SpoonModelObj spoonModelObj, Variant variant) {
        this.spoonModelObj = spoonModelObj;
        this.variant = variant;
    }

    public void ApplyMutation() {
        List<Integer> listLineNoHasBug = new ArrayList<>();
        List<Integer> listLineNoNoBug = new ArrayList<>();
        MutationOpInterface mutationOpInterface = new MutationOpInterface();
        for (Integer key : variant.getWeightPath().keySet()) {
            //System.out.println("all key : " + key);
            if (variant.getWeightPath().get(key) > 0) {
                System.out.println(spoonModelObj.getStatementByLineNo(key));
                listLineNoHasBug.add(key);
                System.out.println("specify key : " + key + " suspicious value : " + variant.getWeightPath().get(key));
            }
            else {
                System.out.println("no bug key : " + key + " mo bug suspicious value : " + variant.getWeightPath().get(key));
                listLineNoNoBug.add(key);
            }
        }
        Random random = new Random();
        int randLineHasBug = listLineNoHasBug.get(random.nextInt(listLineNoHasBug.size()));
        int randLineNoBug = listLineNoNoBug.get(random.nextInt(listLineNoNoBug.size()));
        CtStatement ctRandLineHasBug = spoonModelObj.getStatementByLineNo(randLineHasBug);
        CtStatement ctRandLineNoBug = spoonModelObj.getStatementByLineNo(randLineNoBug);
        System.out.println("dong loi : " + randLineHasBug + " la : " + ctRandLineHasBug);
        System.out.println("Dong ko loi : " + randLineNoBug + " la : " + ctRandLineNoBug);
        OperationRamdomer randomMutationOp = new OperationRamdomer(null,ctRandLineHasBug,ctRandLineNoBug);
        randomMutationOp.ApplyRandomOp();

        //statement10.insertBefore(statement6);

    }
}
