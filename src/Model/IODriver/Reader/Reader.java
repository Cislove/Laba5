package Model.IODriver.Reader;

import Model.IODriver.Readable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader{
//    public Reader(){
//        pathToDirectory = "C:/Users/vim15/IdeaProjects/ProgaLab5/ProgramFile";
//    }
//    public Reader(String path){
//        pathToDirectory = path;
//    }

    public String ReadFromFile(String pathToFile) {
        StringBuilder file = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToFile))){
            String line;
            while((line = reader.readLine()) != null){
                file.append(line).append("\n");
            }
        }
        catch (IOException e){
            return null;
        }
        return file.toString();
    }

//    public String getPathToDirectory() {
//        return pathToDirectory;
//    }
//
//    public void setPathToDirectory(String pathToDirectory) {
//        this.pathToDirectory = pathToDirectory;
//    }
}
