package Model.IODriver.Writter;


import Model.IODriver.Writeable;

import java.io.FileWriter;
import java.io.IOException;


public class Writter{
    public Writter(){
    }
    public int writeToFile(String pathToFile, String file){
        try (FileWriter fw = new FileWriter(pathToFile)) {
            fw.write(file);
        }
        catch (IOException e) {
            return -1;
        }
        return 0;
    }
//    public int writeToFile(String file){
//        return writeToFile("Main", file);
//    }

//    public String getPathToDirectory() {
//        return pathToDirectory;
//    }
//
//    public void setPathToDirectory(String pathToDirectory) {
//        this.pathToDirectory = pathToDirectory;
//    }
}
