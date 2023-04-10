package readers.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestMapper {

    @Test
    public void testMapConfig1() throws IOException{
        String file = "src/test/resources/datafiles/Config1.json";

        ObjectMapper mapper = new ObjectMapper();
        Config1Pojo config = mapper.readValue(new FileReader(file), Config1Pojo.class);

        System.out.println("config = " + config);
        System.out.println("---------------------------");
        System.out.println("config.getUrl() = " + config.getUrl());
        System.out.println("config.getUsername() = " + config.getUsername());
        System.out.println("config.getPassword() = " + config.getPassword());
    }


    @Test
    public void testMapConfig1Lombok() throws IOException{
        String file = "src/test/resources/datafiles/Config1.json";

        ObjectMapper mapper = new ObjectMapper();
        Config1PojoLombok config = mapper.readValue(new FileReader(file), Config1PojoLombok.class);

        System.out.println("config = " + config);
    }

    @Test
    public void testMapConfig() throws IOException{
        String file = "src/test/resources/datafiles/config.json";

        ObjectMapper mapper = new ObjectMapper();
        ConfigPojo config = mapper.readValue(new FileReader(file), ConfigPojo.class);

        System.out.println("config = " + config);
    }
}
