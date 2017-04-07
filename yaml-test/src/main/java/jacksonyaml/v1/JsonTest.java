package jacksonyaml.v1;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import common.User;

import java.util.ArrayList;
import java.util.List;

public class JsonTest {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
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
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));

            System.out.println("Read YAML ... ... ... ");
            String userYaml = "{\n" +
                    "  \"firstName\" : \"Amit\",\n" +
                    "  \"lastName\" : \"Kaneria\",\n" +
                    "  \"address\" : [ \"130 Laidlaw Ave\", \"Jersey City\", \"NJ 07307\" ]\n" +
                    "}";

            User newUser = mapper.readValue(userYaml, User.class);
            System.out.println(newUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
