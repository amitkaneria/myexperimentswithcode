package jackson.v1;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import common.User;
import common.UserAddress;
import common.UserUtil;
import jackson.v1.factory.JacksonDataFormatFactory;

public class Test {
    public static void main(String[] args) {
        CsvMapper mapper = (CsvMapper) JacksonDataFormatFactory.objectMapper("csv");
        try {
            User user = UserUtil.getUserInstance();

            CsvSchema schema = mapper.schemaFor(User.class).withColumnSeparator(',');
            ObjectWriter objectWriter = mapper.writer(schema);
            System.out.println("Write ... ... ... ");
            System.out.println(objectWriter.writeValueAsString(user));

            System.out.println("Read ... ... ... ");
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
