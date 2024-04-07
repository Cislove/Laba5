package Model.IODriver.XMLConverter;

import Model.Storage.Storage;
import Model.Storage.StorageObject.StudyGroup;
import Model.XMLCollection;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.LinkedList;

public class Converter {
    XmlMapper mapper = new XmlMapper();
    public String Serialize(XMLCollection collection){
        try {
            //XmlMapper xmlMapper = new XmlMapper();
            //String xml = xmlMapper.writeValueAsString(list);
            return mapper.writeValueAsString(collection);
        } catch (IOException e) {
            throw new RuntimeException(e);
            //return null;
        }
    }
}
