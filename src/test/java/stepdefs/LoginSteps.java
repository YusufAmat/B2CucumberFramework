package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.LoginObjects;
import readers.property.PropertyReader;
import utils.Utils;

import java.util.List;
import java.util.Map;

public class LoginSteps extends BaseSteps{

    LoginObjects loginObjects;
    @Given("user on homepage")
    public void userOnHomepage() {
        loginObjects = new LoginObjects();
        String url = PropertyReader.read().get("url");
        driver.get(url);
    }

    @When("user clicks My Account Link")
    public void userClicksMyAccountLink() {
        click(loginObjects.menuMyAccountLink);
    }

    @And("user clicks Login Link")
    public void userClicksLoginLink() {
        click(loginObjects.menuLoginLink);
    }

    @Then("Login page should be visible")
    public void loginPageShouldBeVisible() {
        waitForVisibility(loginObjects.loginFormUsername);
    }

    @When("user fill the login form with the following data")
    public void userFillTheLoginFormWithTheFollowingData(DataTable table) {
        Map<String, String> map = table.asMap();
        sendkeys(loginObjects.loginFormUsername, map.get("username"));
        sendkeys(loginObjects.loginFormPassword, map.get("password"));
        Assert.fail();
    }

    @And("user clicks Login button")
    public void userClicksLoginButton() {
        click(loginObjects.loginFormSubmitButton);
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        waitForVisibility(loginObjects.lSiteMapAccout);
    }

    @When("user clicks the following links with text")
    public void userClicksTheFollowingLinksWithText(DataTable table) {
        String xpathOfLink = "//a[contains(., '%s')]";
        List<String> list = table.asList();
        for (String text : list) {
            By locator = By.xpath(String.format(xpathOfLink, text));
            click(locator);
        }

    }

    @Then("login should be {string}")
    public void loginShouldBe(String arg0) {

    }
}
