package Mutation;

import spoon.reflect.code.CtStatement;

public class DeleteStament extends MutationOpInterface {
    @Override
    public void ApplyChange(CtStatement sourceStatement, CtStatement insertStatatement) {
        insertStatatement.delete();
    }
}
