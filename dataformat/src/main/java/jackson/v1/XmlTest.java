package jackson.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.UserAddress;
import common.UserUtil;
import jackson.v1.factory.JacksonDataFormatFactory;

public class XmlTest {
    public static void main(String[] args) {
        ObjectMapper mapper = JacksonDataFormatFactory.objectMapper("xml");
        try {
            UserAddress userAddress = UserUtil.getUserAddressInstance();

            System.out.println("Write XML ... ... ... ");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userAddress));

            System.out.println("Read XML ... ... ... ");
            String userYaml = "<UserAddress><firstName>Amit</firstName><lastName>Kaneria</lastName><address><address>130 Laidlaw Ave</address><address>Jersey City</address><address>NJ 07307</address></address></UserAddress>";

            UserAddress newUserAddress = mapper.readValue(userYaml, UserAddress.class);
            System.out.println(newUserAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
