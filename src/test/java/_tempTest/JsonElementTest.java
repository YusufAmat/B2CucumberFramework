package _tempTest;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import stepdefs.BaseSteps;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonElementTest extends BaseSteps {

    @Test
    public void test1() throws FileNotFoundException {
        driver.get(getValue("application", "url"));
        click(getBy("topmenu", "myaccount"));
        click(getBy("topmenu","loginlink"));
    }

    public By getBy(String main, String sub) throws FileNotFoundException {
        String jsonFile = "src/test/resources/datafiles/Elements.json";

        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));

        JSONObject mainNode = (JSONObject) object.get(main);
        JSONObject subNode = (JSONObject) mainNode.get(sub);

        String type = subNode.get("type").toString();
        String locator = subNode.get("locator").toString();

        switch (type.toLowerCase()){
            case "xpath" : return By.xpath(locator);
            case "css" : return By.cssSelector(locator);
            case "id" : return By.id(locator);
            case "tagname" : return By.tagName(locator);
            case "classname" : return By.className(locator);
            case "linktext" : return By.linkText(locator);
            case "partiallinktext" : return By.partialLinkText(locator);
            default: return null;
        }
    }

    public static String getValue(String main, String key) throws FileNotFoundException {
        String jsonFile = "src/test/resources/datafiles/Elements.json";

        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));

        JSONObject mainNode = (JSONObject) object.get(main);
        return mainNode.get(key).toString();

    }


}
