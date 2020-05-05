package junit.util;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
public class ExcutionListener extends RunListener {
    private long startTime;
    private long endTime;

    /**
     * Called before any tests have been run.
     */
    @Override
    public void testRunStarted(Description description) throws java.lang.Exception {
        System.out.println("Tests started! Number of tests to execute : " + description.testCount());
        startTime = System.currentTimeMillis();
    }
}
