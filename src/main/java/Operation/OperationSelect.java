package Operation;

import spoon.reflect.code.CtStatement;

public class OperationSelect {
    ModificationStm modificationStm;
    CtStatement originStsm;
    CtStatement fixStsm;
    public void setModificationStm(ModificationStm modificationStm) {
        this.modificationStm = modificationStm;
    }

    public void setOriginStsm(CtStatement originStsm) {
        this.originStsm = originStsm;
    }

    public void setFixStsm(CtStatement fixStsm) {
        this.fixStsm = fixStsm;
    }

    public ModificationStm getModificationStm() {
        return modificationStm;
    }

    public CtStatement getOriginStsm() {
        return originStsm;
    }

    public CtStatement getFixStsm() {
        return fixStsm;
    }



}
