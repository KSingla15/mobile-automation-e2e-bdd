package listeners;

import org.openqa.selenium.NoSuchElementException;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static int maxRetryCount = 3; // Set the maximum retry limit here

    public static void setMaxRetryCount(int maxRetryCount) {
        RetryAnalyzer.maxRetryCount = maxRetryCount;
    }

    @Override
    public boolean retry(ITestResult result) {
        Throwable throwable = result.getThrowable();
        if (retryCount < maxRetryCount) {
            if ((throwable instanceof AssertionError) || (throwable instanceof NoSuchElementException)) {
                retryCount++;
                return true; // Retry the test
            }
        }
        return false; // No more retries
    }
}