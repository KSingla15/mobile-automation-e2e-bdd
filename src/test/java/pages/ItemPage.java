package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static actions.MobileElementAction.click;

public class ItemPage extends BasePageImpl {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"counter plus button\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView")
    private WebElement plusButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Add To Cart button\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add To Cart\"]")
    private WebElement addToCart;

    public ItemPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickPlus() {
        click(plusButton);
    }

    public void addToCart(){
        click(addToCart);
    }
}
