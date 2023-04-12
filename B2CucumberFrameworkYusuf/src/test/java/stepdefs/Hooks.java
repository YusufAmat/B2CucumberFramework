package stepdefs;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import readers.property.PropertyReader;

public class Hooks {

    @After(order=1)
    public void after1(Scenario scenario){
        boolean scrShot = PropertyReader.read().get("takescreenshot").equalsIgnoreCase("true");
        if (scrShot && scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }


    @After(order=0)
    public void after0(){
        Driver.quitDriver();
    }
}
