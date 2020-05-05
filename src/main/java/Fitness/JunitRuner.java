package Fitness;

import JavaTest.TestTask;
import ObjectGenProg.TestCase;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Callable;

import static com.google.common.base.Preconditions.checkNotNull;

public class JunitRuner implements Callable<Result> {
    //private final Object testClasses;
    private final RunListener listener;
    private String methodName;

    public String testCaseName(){
        return methodName;
    }
    public JunitRuner(RunListener listener, String methodName) {
        //this.testClasses = classes;
        this.listener = listener;
        this.methodName = methodName;
    }
    public Result call() throws Exception {
        JUnitCore runner = new JUnitCore();
        runner.addListener(listener);
        //Class<?>[] testClasses = TestTask.class;
        try {
            Request request = Request.method(TestTask.class,testCaseName());
            Result result = runner.run(request);
            //System.out.println("I : " + _Instrumenting.lines);
            return result;

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


}
