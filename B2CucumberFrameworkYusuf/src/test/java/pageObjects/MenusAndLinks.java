package pageObjects;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import stepdefs.BaseSteps;

public class MenusAndLinks extends BaseSteps {
    String MAINMENU= "//nav[@class='navbar']//a[text()='%s']";
    String MAINMENU_SUBMENU= "//nav[@class='navbar']//li[contains(.,'%s')]//a[text()='%s']";
    String TOPMENU= "//div[@class='nav pull-right']//*[contains(text(),'%s')]";
    String TOPMENU_SUBMENU= "//div[@class='nav pull-right']//li[contains(.,'%s')]//a[text()='%s']";
    String RIGHTMENU= "//div[@class='list-group']//*[text()='%s']";
    String FOOTERMENU= "//footer//*[text()='%s']";
    String urlAccount = "https://opencart.abstracta.us/index.php?route=account/account";
    String urlLogin = "https://opencart.abstracta.us/index.php?route=account/login";


    @Test
    public void clickMenuAndLink(){
        driver.get(urlLogin);
        sendKeys(driver.findElement(By.id("input-email")), "deneme@deneme.com");
        sendKeys(driver.findElement(By.id("input-password")), "deneme");
        click(driver.findElement(By.xpath("//input[@value='Login']")));

        clickMainMenu("Desktops");
        clickMainMenu("Desktops", "PC (0)");

        clickTopMenu("My Account");
        clickTopMenu("My Account", "Downloads");

        clickRightMenu("Password");

        clickFooterMenu("About Us");

        Driver.quitDriver();
    }

    public void clickMainMenu(String link){
        click(By.xpath(String.format(MAINMENU, link)));
        driver.navigate().to(urlAccount);
    }

    public void clickMainMenu(String link, String subMenu){
        clickMainMenu(link);
        click(By.xpath(String.format(MAINMENU_SUBMENU,link,subMenu)));
        driver.navigate().to(urlAccount);
    }

    public void clickTopMenu(String link){
        click(By.xpath(String.format(TOPMENU, link)));
        driver.navigate().to(urlAccount);
    }

    public void clickTopMenu(String link, String subMenu){
        clickTopMenu(link);
        click(By.xpath(String.format(TOPMENU_SUBMENU,link,subMenu)));
        driver.navigate().to(urlAccount);
    }

    public void clickRightMenu(String link){
        click(By.xpath(String.format(RIGHTMENU, link)));
        driver.navigate().to(urlAccount);
    }

    public void clickFooterMenu(String link){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 300);");
        click(By.xpath(String.format(FOOTERMENU, link)));
        driver.navigate().to(urlAccount);
    }

}
