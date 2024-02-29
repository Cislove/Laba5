package Model.IODriver.Writter;


import Model.IODriver.Writeable;

import java.io.FileWriter;
import java.io.IOException;


public class Writter implements Writeable {
    private String pathToDirectory;
    public Writter(){
        pathToDirectory = "C:/Users/vim15/IdeaProjects/ProgaLab5/ProgramFile";
    }
    public Writter(String path){
        pathToDirectory = path;
    }
    public int writeToFile(String name, String file){
        try (FileWriter fw = new FileWriter(pathToDirectory + "/" + name)) {
            fw.write(file);
        }
        catch (IOException e) {
            return -1;
        }
        return 0;
    }
    public int writeToFile(String file){
        return writeToFile("Main", file);
    }

    public String getPathToDirectory() {
        return pathToDirectory;
    }

    public void setPathToDirectory(String pathToDirectory) {
        this.pathToDirectory = pathToDirectory;
    }
}
