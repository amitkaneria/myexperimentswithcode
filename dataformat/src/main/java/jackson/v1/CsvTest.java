package jackson.v1;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import common.User;
import common.UserAddress;
import common.UserUtil;
import jackson.v1.factory.JacksonDataFormatFactory;

public class CsvTest {
    public static void main(String[] args) {
        CsvMapper mapper = (CsvMapper) JacksonDataFormatFactory.objectMapper("csv");
        try {
            User user = UserUtil.getUserInstance();

            CsvSchema schema = mapper.schemaFor(User.class).withHeader().withColumnSeparator(',');
            ObjectWriter objectWriter = mapper.writer(schema);
            System.out.println("Write ... ... ... ");
            System.out.println(objectWriter.writeValueAsString(user));

            System.out.println("Read ... ... ... ");
            String userYaml = "firstName,lastName\n" +
                    "Amit,Kaneria";

            ObjectReader objectReader = mapper.reader(schema);
            User newUser = objectReader.readValue(userYaml);
            System.out.println(newUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
