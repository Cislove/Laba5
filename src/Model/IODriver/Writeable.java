package Model.IODriver;

import java.io.IOException;

public interface Writeable {
    int writeToFile(String file) ;
    int writeToFile(String name, String flie) ;
}
