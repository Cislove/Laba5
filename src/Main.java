import Model.IODriver.Reader.Reader;
import Model.IODriver.Writter.Writter;

public class Main {
    public static void main(String[] args) {
        Reader r = new Reader();
        Writter w = new Writter();
        String s = "Hello world!\nPoka loh!";
        w.writeToFile(s);
        System.out.println(r.ReadFromFile());
    }
}