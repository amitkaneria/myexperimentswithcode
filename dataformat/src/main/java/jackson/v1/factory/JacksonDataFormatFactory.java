package jackson.v1.factory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class JacksonDataFormatFactory {

    public static ObjectMapper objectMapper(String type){
        ObjectMapper objectMapper = null;
        if(type != null && type.equalsIgnoreCase("yaml")){
            objectMapper = new ObjectMapper(new YAMLFactory());
        }else if(type != null && type.equalsIgnoreCase("json")){
            objectMapper = new ObjectMapper(new JsonFactory());
        }else if(type != null && type.equalsIgnoreCase("xml")){
            objectMapper = new XmlMapper(new XmlFactory());
        }else if(type != null && type.equalsIgnoreCase("csv")){
            objectMapper = new CsvMapper(new CsvFactory());
//        }else if(type != null && type.equalsIgnoreCase("text")){
//            return new ObjectMapper(new TextFac());
//        }else if(type != null && type.equalsIgnoreCase("binary")){
//            return new ObjectMapper(new BinaryFac());
        }else if(type != null && type.equalsIgnoreCase("cbor")){
            objectMapper = new ObjectMapper(new CBORFactory());
        }else if(type != null && type.equalsIgnoreCase("properties")){
            objectMapper = new ObjectMapper(new JavaPropsFactory());
        }else {
            return null;
        }

        return objectMapper;
    }
}