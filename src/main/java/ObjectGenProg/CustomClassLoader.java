package ObjectGenProg;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassLoader extends ClassLoader {
    public void invokeClassMethod (String classBinName, String methodName) {
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            Class loadedMyClass = classLoader.loadClass(classBinName);
            Constructor constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();
            Method method = loadedMyClass.getMethod(methodName);
            System.out.println("method" + method.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
