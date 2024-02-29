package Model.IODriver.Reader;

import Model.IODriver.Readable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader implements Readable {
    private String pathToDirectory;
    public Reader(){
        pathToDirectory = "C:/Users/vim15/IdeaProjects/ProgaLab5/ProgramFile";
    }
    public Reader(String path){
        pathToDirectory = path;
    }
    @Override
    public String ReadFromFile() {
        return ReadFromFile("Main");
    }

    @Override
    public String ReadFromFile(String name) {
        StringBuilder file = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToDirectory + "/" + name))){
            String line;
            while((line = reader.readLine()) != null){
                file.append(line).append("\n");
            }
        }
        catch (IOException e){
            return file.toString();
        }
        return file.toString();
    }

    public String getPathToDirectory() {
        return pathToDirectory;
    }

    public void setPathToDirectory(String pathToDirectory) {
        this.pathToDirectory = pathToDirectory;
    }
}
