package setup;

import context.TestContext;
import io.appium.java_client.AppiumDriver;
import setup.capabilities.AppiumConfiguration;
import setup.capabilities.PlatformConfigurationFactory;
import utils.ConfigurationReader;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    public static AppiumDriver createDriver() throws IOException {
        AppiumConfiguration appiumConfiguration = resolveAppiumConfiguration();
        URL appiumServerUrl = new URL(TestContext.appiumServerDetail.url());
        AppiumDriver driver = new AppiumDriver(appiumServerUrl, appiumConfiguration.capabilities());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigurationReader.getImplicitWaitTime()));
        return driver;
    }

    private static AppiumConfiguration resolveAppiumConfiguration() throws IOException {
        String platformName = ConfigurationReader.getPlatformName();

        PlatformConfigurationFactory factory = PlatformConfigurationFactory.getFactory(platformName, TestContext.isLocalMode);

        return factory.createConfiguration();
    }
}
