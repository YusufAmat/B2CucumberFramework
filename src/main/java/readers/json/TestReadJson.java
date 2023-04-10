package readers.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;

public class TestReadJson {


    @Test
    public void readConfig1() throws Exception{

        // olunacak json dosyasi
        String file = "src/test/resources/datafiles/Config1.json";

        // Config1.json JSONbjeckt olarak okunuyor
        //JSONObject object = (JSONObject) JSONValue.parse(new FileReader(file));
        JSONObject object = (JSONObject) new JSONParser().parse(new FileReader(file));
        System.out.println(object);
        System.out.println("------------");
        System.out.println(object.get("url"));
        System.out.println(object.get("username"));
        System.out.println(object.get("password"));
    }


    @Test
    public void readConfig2() throws Exception{
        String file = "src/test/resources/datafiles/Config2.json";
        JSONObject json = (JSONObject) JSONValue.parse(new FileReader(file));
        System.out.println(json.get("types"));


        JSONObject address = (JSONObject) json.get("address");
        System.out.println(address.get("city"));



        // array olan type degerini JSONArray'a atiyorum
        JSONArray types = (JSONArray) json.get("types");
        for (Object type : types) {
            System.out.println(type);
        }
        System.out.println("----------------");



        JSONArray users = (JSONArray) json.get("users");


        for (Object user : users) {
            JSONObject userObj = (JSONObject) user;
            System.out.println(userObj.get("username"));
            System.out.println(userObj.get("password"));
        }

    }


}
