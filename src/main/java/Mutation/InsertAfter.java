package Mutation;

import spoon.reflect.code.CtStatement;

public class InsertAfter extends MutationOpInterface{
    @Override
    public void ApplyChange(CtStatement sourceStatement, CtStatement insertStatatement) {
        insertStatatement.insertAfter(sourceStatement);
    }
}
