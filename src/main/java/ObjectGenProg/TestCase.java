package ObjectGenProg;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    List<String> param = new ArrayList<>();
    Boolean resultOfTest;
    String methodNameTC;

    public Boolean getNegativeEffect() {
        return isNegativeEffect;
    }

    public void setNegativeEffect(Boolean negativeEffect) {
        isNegativeEffect = negativeEffect;
    }

    Boolean isNegativeEffect = false;
    public String getMethodNameTC() {
        return methodNameTC;
    }

    public void setMethodNameTC(String methodName) {
        this.methodNameTC = methodName;
    }

    public List<String> getParam() {
        return param;
    }

    public Boolean getResultOfTest() {
        return resultOfTest;
    }

    public void setParam(List<String> param) {
        this.param = param;
    }

    public void setResultOfTest(Boolean resultOfTest) {
        this.resultOfTest = resultOfTest;
    }
}
