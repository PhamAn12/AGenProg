package Fitness;


import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class JunitExecer {
    public Result process(RunListener listener, String testCaseName) throws ExecutionException, InterruptedException {
        List<Future<Result>> list = new ArrayList<>();

        // Get ExecutorService from Executors utility class, thread pool size is 1
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Callable<Result> callable;
        Future<Result> future;
        callable = new JunitRuner(listener,testCaseName);
        future = executor.submit(callable);

        list.add(future);

        executor.shutdown();

        while (!executor.isTerminated()) {

        }

        return future.get();
    }
}
