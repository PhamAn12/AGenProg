package Operation;

import Helper.MutationHelper;
import ObjectGenProg.ProjectFacade;
import ObjectGenProg.SpoonModelObj;
import com.fasterxml.jackson.core.JsonToken;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ModelBuiler {
    private ProjectFacade projectFacade;

    public ModelBuiler(ProjectFacade projectFacade) {
        this.projectFacade = projectFacade;
    }

    public List<SpoonModelObj> GetModelElements() {
        List<SpoonModelObj> spoonModelObjList = new ArrayList<SpoonModelObj>();
        List<CtStatement> statementOfMethodList = new ArrayList<>();
        CtModel projectModelSM = MutationHelper.BuildModel(projectFacade);
        List<CtClass> allClassList = projectModelSM.getElements(new TypeFilter<>(CtClass.class));
        for (CtClass classSM : allClassList) {
            SpoonModelObj spoonModelObj = new SpoonModelObj();
            spoonModelObj.setClassSM(classSM);
            //System.out.println("Class name : " + classSM.getSimpleName());
            Set<CtMethod> listMethodOfEachClass = classSM.getAllMethods();
            spoonModelObj.setListMethodSM(listMethodOfEachClass);
            for (CtMethod methodSM : listMethodOfEachClass) {
                //System.out.println("method name : " + methodSM.getSimpleName());
                for (CtStatement statement : methodSM.getBody().getStatements()) {
                    //System.out.println("statement : " + statement.getDirectChildren());
//                    for(CtElement ct : statement.getDirectChildren()) {
//                        if(ct instanceof CtBlock) {
//                            //System.out.println("Block : " + ct);
//                            for(CtStatement sss : ((CtBlock) ct).getStatements()){
//                                System.out.println("SSS : " +sss + " VT: " + sss.getPosition().getLine());
//                                System.out.println("parent : " + sss.getParent());
//                            }
//                        }
//                    }
                    if(!(statement instanceof CtBlock))
                        statementOfMethodList.add(statement);
                    VisitBlock(statement, statementOfMethodList);
                }
                spoonModelObj.setListStatementSM(statementOfMethodList);
            }
            spoonModelObjList.add(spoonModelObj);
//            for(SpoonModelObj spO: spoonModelObjList){
//                spO.printSomething();
//                System.out.println("statement 13: " + spO.getStatementByLineNo(13));
//            }

        }
        return spoonModelObjList;
        //System.out.println(statementOfMethodList);
    }

    void VisitBlock(CtElement statement,List<CtStatement> singleLine) {
        for (CtElement childStatement : statement.getDirectChildren()) {
            if (childStatement instanceof CtBlock) {
                for (CtStatement childStsm : ((CtBlock) childStatement).getStatements()) {

                    if(!(childStsm instanceof CtIf)) {
                        //System.out.println("COOOOOOONNNN : " + childStsm);
                        singleLine.add(childStsm);
                    }
                }
                VisitBlock(childStatement,singleLine);

            } else {
                VisitBlock(childStatement,singleLine);
                //System.out.println("DDDDDDUOOOOI : " + childStatement);
            }
        }

    }

}
