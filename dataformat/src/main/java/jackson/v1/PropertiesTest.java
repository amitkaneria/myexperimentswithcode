package jackson.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.UserAddress;
import common.UserUtil;
import jackson.v1.factory.JacksonDataFormatFactory;

public class PropertiesTest {
    public static void main(String[] args) {
        ObjectMapper mapper = JacksonDataFormatFactory.objectMapper("csv");
        try {
            UserAddress userAddress = UserUtil.getUserAddressInstance();

            System.out.println("Write JAVA PROPERTIES ... ... ... ");
            System.out.println(mapper.writeValueAsString(userAddress));

            System.out.println("Read JAVA PROPERTIES ... ... ... ");
            String userYaml = "firstName=Amit\n" +
                    "lastName=Kaneria\n" +
                    "address.1=130 Laidlaw Ave\n" +
                    "address.2=Jersey City\n" +
                    "address.3=NJ 07307";

            UserAddress newUserAddress = mapper.readValue(userYaml, UserAddress.class);
            System.out.println(newUserAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
