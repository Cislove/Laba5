package Model.IODriver.XMLConverter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class Converter {
    XmlMapper mapper = new XmlMapper();
    public String Serialize(XMLCollection collection){
        try {
            return mapper.writeValueAsString(collection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
