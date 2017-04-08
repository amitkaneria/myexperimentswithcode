package jackson.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.User;

import java.util.ArrayList;
import java.util.List;

public class YamlTest {
    public static void main(String[] args) {
        ObjectMapper mapper = JacksonDataFormatFactory.objectMapper("csv");
        try {
            User user = new User();
            user.setFirstName("Amit");
            user.setLastName("Kaneria");
            List<String> address = new ArrayList<>();
            address.add("130 Laidlaw Ave");
            address.add("Jersey City");
            address.add("NJ 07307");
            user.setAddress(address);

            System.out.println("Write YAML ... ... ... ");
            System.out.println(mapper.writeValueAsString(user));

            System.out.println("Read YAML ... ... ... ");
            String userYaml = "---\n" +
                    "firstName: \"Amit\"\n" +
                    "lastName: \"Kaneria\"\n" +
                    "address:\n" +
                    "- \"130 Laidlaw Ave\"\n" +
                    "- \"Jersey City\"\n" +
                    "- \"NJ 07307\"";

            User newUser = mapper.readValue(userYaml, User.class);
            System.out.println(newUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
