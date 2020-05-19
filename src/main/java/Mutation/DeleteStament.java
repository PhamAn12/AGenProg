package Mutation;

import Population.Variant;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtElement;

public class DeleteStament {
    public void ApplyChange(CtStatement sourceStatement, Variant variant) {
//        sourceStatement.delete();
//        CtBlock parentBlock =(CtBlock) sourceStatement.getParent();
//        insertStatatement.delete();
//        System.out.println(parentBlock);
//        int index = parentBlock.getStatements().indexOf(sourceStatement);
//        System.out.println("Index la : " + index);
//        parentBlock.getStatements().remove(index);
//        variant.getContext().replace(sourceStatement.toString(),"");
        CtStatement ctStatement = null;
        System.out.println("SSS statement : " + sourceStatement);
        sourceStatement.replace(ctStatement);

    }
}
