package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "stepdefinitions", // Package with your step definitions
        tags = "@AddItemsToCart", // Tag to filter scenarios to be executed
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html",
                "junit:target/cucumber-report/cucumber.xml"},
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
