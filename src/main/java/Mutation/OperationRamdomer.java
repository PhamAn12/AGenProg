package Mutation;

import spoon.reflect.code.CtStatement;

import java.util.Random;

public class OperationRamdomer {
    private MutationOpInterface mutationOpInterface;
    private CtStatement statementSource;
    private CtStatement statementModified;
    public OperationRamdomer(MutationOpInterface mutationOpInterface,CtStatement statementSource,CtStatement statementModified) {
        this.mutationOpInterface = mutationOpInterface;
        this.statementSource = statementSource;
        this.statementModified = statementModified;
    }
    public void ApplyRandomOp(){
        Random random = new Random();
        int opSelected = random.nextInt(1);
        System.out.println("Number duoc chon : " + opSelected);
        if(opSelected == 0) {
            InsertAfter insertAfter =new InsertAfter();
            insertAfter.ApplyChange(statementSource,statementModified);
        }
        else if(opSelected == 1) {
            InsestBefore insestBefore = new InsestBefore();
            insestBefore.ApplyChange(statementSource,statementModified);
        }
        else if(opSelected == 2) {
            ReplaceOp replaceOp = new ReplaceOp();
            replaceOp.ApplyChange(statementSource,statementModified);
        }
        else {
            DeleteStament deleteStament = new DeleteStament();
            deleteStament.ApplyChange(null,statementModified);
        }
    }

}
