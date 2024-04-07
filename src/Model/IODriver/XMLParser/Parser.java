package Model.IODriver.XMLParser;

import Model.Storage.Storage;
import Model.Storage.StorageObject.StudyGroup;
import Model.XMLCollection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.LinkedList;

public class Parser {
    XmlMapper mapper = new XmlMapper();
    public Parser(){
//        mapper.registerModule(new JavaTimeModule());
//        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
    public XMLCollection parser(String xml){
        try {
            mapper.registerModule(new JavaTimeModule());
            //System.out.println(mapper.readValue(xml, XMLCollection.class));
            return mapper.readValue(xml, XMLCollection.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
