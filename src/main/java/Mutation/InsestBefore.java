package Mutation;

import spoon.reflect.CtModel;
import spoon.reflect.code.CtStatement;

public class InsestBefore {
    public void ApplyChange(CtStatement sourceStatement,CtStatement insertStatatement) {
        insertStatatement.insertAfter(sourceStatement);
    }

}
