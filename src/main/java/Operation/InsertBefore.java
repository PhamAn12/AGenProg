package Operation;

import GzFaulocalization.FaulResult;
import GzFaulocalization.SuspiciousCode;
import ObjectGenProg.SpoonModelObj;
import spoon.reflect.code.CtStatement;

import java.util.ArrayList;
import java.util.List;

public class InsertBefore implements ModifyOp {
    private FaulResult faulResult;
    private ModelBuiler md;
    private OperationSelect operationSelect;
    public InsertBefore (OperationSelect os,ModelBuiler md, FaulResult fR){
        this.operationSelect = os;
        this.md = md;
        this.faulResult = fR;
    }

    public List<SuspiciousCode> getTwoModifyPoints () {
        List<SuspiciousCode> twoPointForModify = new ArrayList<>();
        SuspiciousCode originstsm = operationSelect.getOriginStsm(faulResult);
        System.out.println("Line number of suspicious code : " + originstsm.getLineNo() +"   " + originstsm.getSuspiciousScore());
        SuspiciousCode fixstsm = operationSelect.getFixStsm(faulResult);
        System.out.println("Line number of fix code : " + fixstsm.getLineNo() + "  " + fixstsm.getSuspiciousScore());

        twoPointForModify.add(originstsm);
        twoPointForModify.add(fixstsm);
        return twoPointForModify;
    }

    @Override
    public boolean ApplyChange() {
        List<SuspiciousCode> twoPointForModify = getTwoModifyPoints();
        List<SpoonModelObj> spoonModelObjList = md.GetModelElements();
        for (SpoonModelObj spoonModelObj: spoonModelObjList) {
            //System.out.println("class nem : " + spoonModelObj.getClassSM().getQualifiedName());
            if(spoonModelObj.getClassSM().getQualifiedName().equals(twoPointForModify.get(1).getClassName())){
//                System.out.println(twoPointForModify.get(1).getClassName());
//                System.out.println(twoPointForModify.get(1));
                System.out.println(spoonModelObj.getStatementByLineNo(twoPointForModify.get(1).getLineNo()));
//                System.out.println(twoPointForModify.get(0).getClassName());
//                System.out.println(twoPointForModify.get(0));
                System.out.println(spoonModelObj.getStatementByLineNo(twoPointForModify.get(0).getLineNo()));
            }
        }
        return false;
    }
}
