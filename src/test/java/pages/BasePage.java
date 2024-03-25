package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public interface BasePage {
    By getMobileElement(String fieldName, String actualValue) throws NoSuchFieldException, IllegalAccessException;
    By getMobileElement(String fieldName) throws NoSuchFieldException, IllegalAccessException;
    <T extends BasePage> T navigateTo(Class<T> pageClass, AppiumDriver driver) throws Exception;
}
