package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.lang.reflect.Field;

abstract public class BasePageImpl implements BasePage{

    public By getMobileElement(String fieldName, String actualValue) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(fieldName);
        return By.xpath(field.get(this).toString().replace("placeholder", actualValue));
    }

    public By getMobileElement(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(fieldName);
        return By.xpath(field.get(this).toString());
    }

    public <T extends BasePage> T navigateTo(Class<T> pageClass, AppiumDriver driver) throws Exception {
        // Initialize & return the page object
        return pageClass.getConstructor(AppiumDriver.class).newInstance(driver);
    }
}
