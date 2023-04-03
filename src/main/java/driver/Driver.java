package driver;

import org.openqa.selenium.WebDriver;

import static driver.DriverFactory.*;

public class Driver {
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return getDriver(Browsers.chrome);
    }
    public static WebDriver getDriver(Browsers browser){
        if (drivers.get() == null){
            switch (browser){
                case firefox:
                    drivers.set(createFirefox());
                    break;
                case edge:
                    drivers.set(createEdge());
                    break;
                case ie:
                    drivers.set(createIe());
                    break;
                case safari:
                    drivers.set(createSafari());
                    break;
                default:
                    drivers.set(createChrome());
                    break;
            }
        }
        return drivers.get();
    }

    public static void quitDriver(){
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }

}
