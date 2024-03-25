package actions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileElementAction {

    public static void click(AppiumDriver driver, By by){
        driver.findElement(by).click();
    }

    public static void click(WebElement element){
        element.click();
    }

    public static String getText(WebElement element){
        return element.getText();
    }
}