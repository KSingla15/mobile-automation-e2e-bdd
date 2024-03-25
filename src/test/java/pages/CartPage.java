package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static actions.MobileElementAction.getText;

public class CartPage extends BasePageImpl {
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"total number\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"total number\"]")
    private WebElement totalNumberOfItems;

    public CartPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getTotalNumberOfItems() {
        return getText(totalNumberOfItems);
    }
}
