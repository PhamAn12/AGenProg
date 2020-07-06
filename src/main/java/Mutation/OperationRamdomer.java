package Mutation;

import Population.Variant;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtElement;

import java.util.Random;

public class OperationRamdomer {
    private Variant variant;
    private CtStatement statementSource;
    private CtStatement statementModified;
    public OperationRamdomer(Variant variant,CtStatement statementSource,CtStatement statementModified) {
        this.variant = variant;
        this.statementSource = statementSource;
        this.statementModified = statementModified;
    }
    public void ApplyRandomOp(){
        Random random = new Random();
        int opSelected = random.nextInt(4);
        System.out.println("Number duoc chon : " + opSelected);
        if(opSelected == 0) {

            DeleteStament deleteStament = new DeleteStament();
            deleteStament.ApplyChange(statementModified,null);

        }
        else if(opSelected == 1) {
            InsestBefore insestBefore = new InsestBefore();
            insestBefore.ApplyChange(statementSource,statementModified);
        }
        else if(opSelected == 2) {
            InsertAfter insertAfter =new InsertAfter();
            insertAfter.ApplyChange(statementSource,statementModified);
        }
        else {
            ReplaceOp replaceOp = new ReplaceOp();
            replaceOp.ApplyChange(statementSource,statementModified);
        }
    }

}
