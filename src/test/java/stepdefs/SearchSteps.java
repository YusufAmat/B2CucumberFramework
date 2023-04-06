package stepdefs;

import io.cucumber.java.en.Given;
import pageObjects.PageObjects;

public class SearchSteps extends BaseSteps{

    PageObjects pageObjects = new PageObjects();

    @Given("user search for {string}")
    public void userSearchFor(String textToSearch) {
        sendkeys(pageObjects.eSearchBoxTop, textToSearch);
        click(pageObjects.eSearchButtonTop);
        waitForVisibility(pageObjects.eSearchContainer);
    }
}
