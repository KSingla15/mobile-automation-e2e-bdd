package stepdefinitions;

import context.TestContext;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.*;
import setup.AppiumServerManager;
import setup.Driver;
import utils.ConfigurationReader;
import utils.Generic;

import java.io.IOException;

import static setup.AppiumServerManager.loadAppiumServerDetail;

public class Hooks {
    protected AppiumDriver driver;
    @BeforeAll
    public static void beforeAll(){
        String mode = ConfigurationReader.getAppiumServerMode();
        TestContext.isLocalMode = mode.equals("local");
        if(TestContext.isLocalMode) {
            System.out.println("Starting appium server...");
            AppiumServerManager.start();
        }else{
            System.out.println("No need to start local appium server, as the execution will happen remotely...");
            loadAppiumServerDetail();
        }
    }

    @After(order = 0)
    public void tearDown(){
        System.out.println("Closing driver instance..");
        Driver.closeInstance();
    }

    @After(order = 1)
    public void captureScreenshot(Scenario scenario) throws IOException {
        System.out.println("Capturing screenshot in report..");
        scenario.attach(Generic.getByteScreenshot(), "image/png", scenario.getName());
    }

    @AfterAll
    public static void appiumTearDown(){
        if(TestContext.isLocalMode) {
            System.out.println("Stopping appium server..");
            AppiumServerManager.stop();
        }
    }
}
