package stepdefs;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;


public class Hooks {

    @After(order = 1)
    public void after1(Scenario scenario){


    }

    @After(order = 0)
    public void after0(){

        Driver.quitDriver();
    }
}
