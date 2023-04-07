package textng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepdefs.BaseSteps;

import java.io.FileNotFoundException;
import static utils.Utils.getBy;
import static utils.Utils.getValue;

public class JsonElementTest extends BaseSteps {

    @Test
    public void test1() throws FileNotFoundException {
        driver.get(getValue("application", "url"));

        //By lMyAccount = By.xpath("//div[@id='top-links']//a[contains(.,'My Account')]");
        By lMyAccount = getBy("topmenu", "myaccount");

        click(lMyAccount);

        click(getBy("topmenu","loginlink"));
        //sendkeys(By, text);
        sendkeys(getBy("login", "username"), getValue("application", "username"));
        sendkeys(getBy("login", "password"), getValue("application", "password"));
        click(getBy("login", "submitbutton"));
        waitForVisibility(getBy("account", "sitemapaccount"));

        sendkeys(getBy("search", "searchbox"), "iMac");
        click(getBy("search", "searchbutton"));
        waitForVisibility(getBy("search", "searchcontainer"));
        click(getXpathOfButtonOfListedProduct("iMac", Buttons.wish));
        waitForVisibility(getBy("search", "successalert"));
        Assert.assertTrue(driver.findElement(getBy("search", "successalert")).getText().toLowerCase().contains("wish list!"));

        driver.quit();
    }


}
