package Operation;

import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class ModificationStm {
    private Variant variant;
    public ModificationStm (Variant variant){
        this.variant = variant;
    }
    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public void setCtElement(CtElement ctElement) {
        this.ctElement = ctElement;
    }

    public void setCtClass(CtClass ctClass) {
        this.ctClass = ctClass;
    }

    public void setVariablesOfContext(List<CtVariable> variablesOfContext) {
        this.variablesOfContext = variablesOfContext;
    }

    public Variant getVariant() {
        return variant;
    }

    public CtElement getCtElement() {
        return ctElement;
    }

    public CtClass getCtClass() {
        return ctClass;
    }

    public List<CtVariable> getVariablesOfContext() {
        return variablesOfContext;
    }

    private CtElement ctElement;
    private CtClass ctClass;
    List<CtVariable> variablesOfContext;

}
