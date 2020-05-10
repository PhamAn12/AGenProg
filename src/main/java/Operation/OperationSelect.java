package Operation;

import GzFaulocalization.FaulResult;
import GzFaulocalization.SuspiciousCode;
import ObjectGenProg.ProjectFacade;
import ObjectGenProg.SpoonModelObj;
import spoon.reflect.code.CtStatement;

import java.util.List;
import java.util.Random;

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

    public SuspiciousCode getOriginStsm(FaulResult faulResult) {
        List<SuspiciousCode> suspiciousCodeList = faulResult.getListSuspiciousCode();
        return GetRandomStatement(suspiciousCodeList);
    }

    public SuspiciousCode getFixStsm(FaulResult faulResult){
        List<SuspiciousCode> suspiciousCodeList = faulResult.getListSuspiciousCode();
        return GetRandomFixStatement(suspiciousCodeList);
    }

    public SuspiciousCode GetRandomStatement(List<SuspiciousCode> suspiciousCodeList) {
        Random rand = new Random();
        SuspiciousCode spoonElement;
        String classNameNeedToFind = GetRandomFixStatement(suspiciousCodeList).getClassName();
        System.out.println("Class need to find : " + classNameNeedToFind);
        do {
            spoonElement = suspiciousCodeList.get(rand.nextInt(suspiciousCodeList.size()));
        } while (!spoonElement.getClassName().equals(classNameNeedToFind));
        return spoonElement;
    }
    public SuspiciousCode GetRandomFixStatement(List<SuspiciousCode> suspiciousCodeList) {
        Random rand = new Random();
        SuspiciousCode suspiciousFixCode;
        do{
            suspiciousFixCode = suspiciousCodeList.get(rand.nextInt(suspiciousCodeList.size()));
        }while(suspiciousFixCode.getSuspiciousScore() == 0);
        return suspiciousFixCode;
    }

}
