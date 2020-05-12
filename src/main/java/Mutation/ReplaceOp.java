package Mutation;

import spoon.reflect.code.CtStatement;

public class ReplaceOp extends MutationOpInterface{
    public void ApplyChange(CtStatement sourceStatement, CtStatement insertStatatement) {
        CtStatement tempStatement = sourceStatement;
        insertStatatement.replace(tempStatement);
        sourceStatement.replace(insertStatatement);
    }
}
