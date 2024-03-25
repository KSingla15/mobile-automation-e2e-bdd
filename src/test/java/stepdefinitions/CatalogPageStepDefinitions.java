package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import setup.Driver;
import java.io.IOException;

import static actions.MobileElementAction.click;

public class CatalogPageStepDefinitions {

    private HomePage homePage;
    private CatalogPage catalogPage;
    private ItemPage itemPage;
    private CartPage cartPage;
    private final AppiumDriver driver;

    public CatalogPageStepDefinitions() throws IOException {
        driver = Driver.getInstance();
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() throws IOException {
        homePage = new HomePage(Driver.getInstance());
    }

    @And("I navigate to the catalog")
    public void iNavigateToTheCatalog() {
        catalogPage = homePage.goToCatalog();
    }

    @And("I select {string}")
    public void iSelect(String itemName) throws Exception {
        click(driver, catalogPage.getMobileElement("item", itemName));
    }

    @And("I choose color as {string} of the item")
    public void iChooseColorAsOfTheItem(String color) throws Exception {
        click(driver, catalogPage.getMobileElement("colorCircle", color));
        itemPage = catalogPage.navigateTo(ItemPage.class, driver);

    }

    @And("I add {string} to the cart")
    public void iAddToTheCart(String arg0) {
        itemPage.clickPlus();
    }

    @When("I navigate to the cart")
    public void iNavigateToTheCart() throws Exception {
        itemPage.addToCart();
        click(driver, catalogPage.getMobileElement("tabBarOptionCart"));
        cartPage = itemPage.navigateTo(CartPage.class, driver);
    }

    @Then("the total number of items in the cart should be {string}")
    public void theTotalNumberOfItemsInTheCartShouldBe(String itemCount) {
        Assert.assertEquals(cartPage.getTotalNumberOfItems(), itemCount);
    }
}