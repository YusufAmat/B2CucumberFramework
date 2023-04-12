package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.PageObjects;

public class SearchSteps extends BaseSteps {

    PageObjects pageObjects;

    @Given("user search for {string}")
    public void userSearchFor(String textToSearch) {
        pageObjects = new PageObjects();
        sendKeys(pageObjects.eSearchBoxTop, textToSearch);
        click(pageObjects.eSearchButtonTop);
        waitForVisibility(pageObjects.eSearchContainer);
    }

    @When("user add {string} to the WishList")
    public void userAddToTheWishList(String productName) {
        click(getXpathOfButtonOfListedProduct(productName, 2));
    }

    @Then("success notification with {string} should be visible")
    public void successNotificationWithShouldBeVisible(String text) {
        waitForVisibility(pageObjects.eAlertSuccess);
        Assert.assertTrue(pageObjects.eAlertSuccess.getText().toLowerCase().contains(text.toLowerCase()));
    }
}
