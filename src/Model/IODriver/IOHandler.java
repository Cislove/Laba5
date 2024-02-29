package Model.IODriver;

public class IOHandler implements IFilesWork{
    @Override
    public int writeInstanceToFile(String name, String file) {
        return 0;
    }

    @Override
    public int writeToFile(String name, String File) {
        return 0;
    }

    @Override
    public int writeInstanceToFile(String file) {
        return 0;
    }

    @Override
    public int writeToFile(String File) {
        return 0;
    }

    @Override
    public String readFile(String name, String File) {
        return null;
    }

    @Override
    public String readFile(String File) {
        return null;
    }

    @Override
    public String readInstanceFile(String name, String File) {
        return null;
    }

    @Override
    public String readInstanceFile(String File) {
        return null;
    }
}
