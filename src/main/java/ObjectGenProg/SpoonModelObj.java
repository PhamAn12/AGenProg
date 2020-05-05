package ObjectGenProg;

import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import java.util.List;
import java.util.Set;

public class SpoonModelObj {
    private CtClass classSM;
    private Set<CtMethod> listMethodSM;
    private List<CtStatement> listStatementSM;
    public SpoonModelObj (CtClass classSM, Set<CtMethod> listMethodSM, List<CtStatement> listStatementSM) {
        this.classSM = classSM;
        this.listMethodSM = listMethodSM;
        this.listStatementSM = listStatementSM;
    }
    public void printSomething(){
        System.out.println("class name : " + classSM.getSimpleName());
        System.out.println("list method name : " + listMethodSM);
        System.out.println("list statements : " + listStatementSM);
        for(CtStatement ctStatement : listStatementSM){
            System.out.println("statement line : " + ctStatement.getPosition().getLine());
        }
    }
    public CtStatement getStatementByLineNo(int lineNo) {
        for(CtStatement ctStatement : listStatementSM) {
            if(ctStatement.getPosition().getLine() == lineNo) {
                return ctStatement;
            }
        }
        return null;
    }
    public SpoonModelObj(){
        
    }

    public void setClassSM(CtClass classSM) {
        this.classSM = classSM;
    }

    public void setListMethodSM(Set<CtMethod> listMethodSM) {
        this.listMethodSM = listMethodSM;
    }

    public void setListStatementSM(List<CtStatement> listStatementSM) {
        this.listStatementSM = listStatementSM;
    }

    public CtClass getClassSM() {
        return classSM;
    }

    public Set<CtMethod> getListMethodSM() {
        return listMethodSM;
    }

    public List<CtStatement> getListStatementSM() {
        return listStatementSM;
    }
}
