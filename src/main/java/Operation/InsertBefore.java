package Operation;

import spoon.reflect.code.CtStatement;

public class InsertBefore {
    public boolean ApplyChange (OperationSelect operationSelect, Variant variant) {
        CtStatement originStsm = (CtStatement) operationSelect.getOriginStsm();
        CtStatement fixStsm = (CtStatement) operationSelect.getFixStsm();
        return true;
    }
}
