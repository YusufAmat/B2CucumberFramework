package readers.json;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

import java.io.FileReader;

public class TestReadJson {


    @Test
    public void readConfig1() throws Exception{

        // olunacak json dosyasi
        String file = "src/test/resources/datafiles/Config1.json";

        // Config1.json JSONbjeckt olarak okunuyor
        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(file));
        System.out.println(object);
    }
}
