package jackson.v1;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class JacksonDataFormatFactory {

    public static ObjectMapper objectMapper(String type){
        if(type != null && type.equalsIgnoreCase("yaml")){
            return new ObjectMapper(new YAMLFactory());
        }else if(type != null && type.equalsIgnoreCase("json")){
            return new ObjectMapper(new JsonFactory());
        }else if(type != null && type.equalsIgnoreCase("xml")){
            return new ObjectMapper(new XmlFactory());
        }else if(type != null && type.equalsIgnoreCase("csv")){
            return new ObjectMapper(new CsvFactory());
//        }else if(type != null && type.equalsIgnoreCase("text")){
//            return new ObjectMapper(new TextFac());
//        }else if(type != null && type.equalsIgnoreCase("binary")){
//            return new ObjectMapper(new BinaryFac());
        }else if(type != null && type.equalsIgnoreCase("cbor")){
            return new ObjectMapper(new CBORFactory());
        }else if(type != null && type.equalsIgnoreCase("properties")){
            return new ObjectMapper(new JavaPropsFactory());
        }
        return null;
    }
}