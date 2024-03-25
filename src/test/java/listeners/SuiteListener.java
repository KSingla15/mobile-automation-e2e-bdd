package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utils.ConfigurationReader;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        String retryCountStr = suite.getParameter("maxRetryCount");
        if (retryCountStr != null) {
            int maxRetryCount = Integer.parseInt(retryCountStr);
            RetryAnalyzer.setMaxRetryCount(maxRetryCount);
        }

        String platformName = suite.getParameter("platformName");
        if (platformName != null) {
            ConfigurationReader.setPlatformName(platformName);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        // Can be left empty if there's nothing to execute after suite execution
    }
}