package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageObjects.PageObjects;
import readers.property.PropertyReader;

import java.util.List;
import java.util.Map;

public class LoginSteps extends BaseSteps {

    PageObjects pageObjects;

    @Given("user on homepage")
    public void userOnHomepage() {
        pageObjects = new PageObjects();
        String url = PropertyReader.read().get("url");
        driver.get(url);
    }

    @When("user clicks My Account Link")
    public void userClicksMyAccountLink() {
        click(pageObjects.menuMyAccountLink);
    }

    @And("user clicks Login Link")
    public void userClicksLoginLink() {
        click(pageObjects.menuLoginLink);
    }

    @Then("Login page should be visible")
    public void loginPageShouldBeVisible() {
        waitForVisibility(pageObjects.loginFormUserName);
    }

    @When("user fill the login form with the following data")
    public void userFillTheLoginFormWithTheFollowingData(DataTable table) {
        Map<String, String> map = table.asMap();
        sendKeys(pageObjects.loginFormUserName, map.get("username"));
        sendKeys(pageObjects.loginFormPassword, map.get("password"));
    }

    @And("user clicks Login button")
    public void userClicksLoginButton() {
        click(pageObjects.loginFormSubmitButton);
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        waitForVisibility(pageObjects.columnRightLogoutLink);
    }

    @And("user clicks on Browser back button")
    public void userClicksOnBrowserBackButton() {
        driver.navigate().back();
    }

    @Then("user should not logged out")
    public void userShouldNotLoggedOut() {
        waitForInvisibility(pageObjects.columnRightLoginLink);
    }

    @And("Click on My Account Dropmenu and select Logout option")
    public void clickOnMyAccountDropmenuAndSelectLogoutOption() {
        click(pageObjects.menuMyAccountLink);
        click(pageObjects.menuLogoutLink);
    }

    @Then("user should not get logged in again")
    public void userShouldNotGetLoggedInAgain() {
        waitForInvisibility(pageObjects.columnRightLogoutLink);
    }

    @When("user clicks the following links with text")
    public void userClicksTheFollowingLinksWithText(DataTable table) {
        String xpthOfLink ="//a[contains(., '%s')]";
        List<String> list = table.asList();
        for (String s : list) {
            By locator = By.xpath(String.format(xpthOfLink, s));
            click(locator);
        }
    }


    @Then("login should be {string}")
    public void loginShouldBe(String success) {

        if (success.equalsIgnoreCase("true")){
            waitForVisibility(pageObjects.columnRightLogoutLink);
            click(pageObjects.columnRightLogoutLink);
        }else {
            waitForVisibility(pageObjects.loginFormWarningMessage);
        }
    }

    @When("user login with username {string} and password {string}")
    public void userLoginWithUsernameAndPassword(String username, String password) {
        click(pageObjects.menuMyAccountLink);
        click(pageObjects.menuLoginLink);
        waitForVisibility(pageObjects.loginFormUserName);
        sendKeys(pageObjects.loginFormUserName, username);
        sendKeys(pageObjects.loginFormPassword, password);
        click(pageObjects.loginFormSubmitButton);
    }
}
