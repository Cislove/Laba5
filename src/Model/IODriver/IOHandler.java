package Model.IODriver;

import Model.IODriver.Reader.Reader;
import Model.IODriver.Writter.Writter;
import Model.IODriver.XMLConverter.Converter;
import Model.IODriver.XMLParser.Parser;
import Model.IODriver.XMLConverter.XMLCollection;

import java.io.IOException;

public class IOHandler{
    private final Reader reader;
    private final Writter writter;
    private final Converter converter = new Converter();
    private final Parser parser = new Parser();
    public IOHandler(Reader reader, Writter writter){
        this.reader = reader;
        this.writter = writter;
    }
    public String writeListToFile(XMLCollection collection, String name) {
        String response = "Коллекция успешно записана в файл\n";
        String xml = converter.Serialize(collection);
        if(writter.writeToFile(name, xml) == -1){
            response = "Ошибка записи коллекции, проверьте права доступа к файлу\n";
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
        XMLCollection collection = parser.parser(xml);
        if(collection == null){
            throw new IOException("Файл не соответствует требуемому формату\n");
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
