package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigurationReader;

import static actions.MobileElementAction.click;

public class HomePage extends BasePageImpl {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"total number\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"tab bar option catalog\"]")
    private WebElement catalogMenuOption;

    public HomePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public CatalogPage goToCatalog() {
        click(catalogMenuOption);
        click(catalogMenuOption);

        return pages.PageFactory.getPage(CatalogPage.class, ConfigurationReader.getPlatformName());
    }
}
