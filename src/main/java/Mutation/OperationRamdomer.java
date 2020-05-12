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
        int opSelected = random.nextInt(4);
        System.out.println("Number duoc chon : " + opSelected);
        if(opSelected == 0) {
            InsertAfter insertAfter =(InsertAfter) mutationOpInterface;
            insertAfter.ApplyChange(statementSource,statementModified);
        }
        else if(opSelected == 1) {
            InsestBefore insestBefore = (InsestBefore) mutationOpInterface;
            insestBefore.ApplyChange(statementSource,statementModified);
        }
        else if(opSelected == 2) {
            ReplaceOp replaceOp = (ReplaceOp) mutationOpInterface;
            replaceOp.ApplyChange(statementSource,statementModified);
        }
        else {
            DeleteStament deleteStament = (DeleteStament) mutationOpInterface;
            deleteStament.ApplyChange(null,statementModified);
        }
    }

}
