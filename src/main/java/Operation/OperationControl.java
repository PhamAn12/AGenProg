package Operation;

import spoon.reflect.CtModel;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.ArrayList;
import java.util.List;

public class OperationControl {
    public CtStatement getStamentToFix(Variant variant){
        ModificationStm modificationStm = new ModificationStm(variant);
        CtModel modelVariant = variant.getVariantModel();

        List<CtClass> classListOfVariant = modelVariant.getElements(new TypeFilter<CtClass>(CtClass.class));
        List<CtMethod> methodofClassList =(List<CtMethod>) classListOfVariant.get(0).getAllMethods();
//        methodofClassList.get(0).getPosition().
        return null;
    }

}
