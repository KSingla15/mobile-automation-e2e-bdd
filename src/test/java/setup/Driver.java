package setup;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;

public class Driver {
    private static AppiumDriver appiumDriver;

    public static AppiumDriver getInstance() throws IOException {
        if (appiumDriver == null) {
            appiumDriver = DriverFactory.createDriver();
        }
        return appiumDriver;
    }

    public static void closeInstance(){
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
