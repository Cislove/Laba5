package Model.IODriver;

public interface IFilesWork {
    int writeInstanceToFile(String name, String file);
    int writeToFile(String name, String File);
    int writeInstanceToFile(String file);
    int writeToFile(String File);
    String readFile(String name, String File);
    String readFile(String File);
    String readInstanceFile(String name, String File);
    String readInstanceFile(String File);

}
