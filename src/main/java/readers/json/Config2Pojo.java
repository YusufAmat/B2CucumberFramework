package readers.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import readers.MyPojo;

import java.util.List;
@Getter
@Setter
@ToString
public class Config2Pojo extends MyPojo {
    private String url;
    private String username;
    private String password;
    private List<String> types;
    private Address address;
    private List<User> users;

    @Getter
    @Setter
    @ToString
    public static class User{
        private String type;
        private boolean valid;
        private String username;
        private String password;
    }

    @Getter
    @Setter
    @ToString
    public static class Address{
        private String street;
        private int number;
        private String city;
    }
}
