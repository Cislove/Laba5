package Model.IODriver;

import Model.IODriver.Reader.Reader;
import Model.IODriver.Writter.Writter;
import Model.IODriver.XMLConverter.Converter;
import Model.IODriver.XMLParser.Parser;
import Model.Storage.Storage;
import Model.XMLCollection;

import java.io.IOException;

public class IOHandler{
    private Reader reader;
    private Writter writter;
    private Converter converter = new Converter();
    private Parser parser = new Parser();
    public IOHandler(Reader reader, Writter writter){
        this.reader = reader;
        this.writter = writter;
    }
    public String writeListToFile(XMLCollection collection, String name) {
        String response = "Коллекция успешно записана в файл";
        String xml = converter.Serialize(collection);
        if(writter.writeToFile(name, xml) == -1){
            response = "Ошибка записи коллекции, проверьте права доступа к файлу";
        }
        return response;
    }

    public int writeToFile(String File) {
        return 0;
    }

    public XMLCollection readListFromFile(String name) throws IOException {
        String xml = reader.ReadFromFile(name);
        if(xml == null){
            System.out.println("Ошибка чтения из файла\n");
        }
        //System.out.println(xml);
        XMLCollection collection = parser.parser(xml);
        if(collection == null){
            throw new IOException("Файл не соответствует требуемому формату\n");
            //System.out.println("Ошибка загрузки данных из файла, проверьте их на корректность\n");
        }
        return collection;
    }

    public String readFile(String name) {
        String response;
        response = reader.ReadFromFile(name);
        if(response == null){
            response = "Ошибка чтения из файла\n";
        }
        return response;
    }

}
