package Model.Storage.ObjectDescription;


import java.util.Date;
import java.util.LinkedList;

public class baseMetaData {

    public java.util.Date initDate;
    public String typeCollection;
    public int size;
    public baseMetaData(){
        typeCollection = "LinkedList";
        size = 0;
        initDate = new Date();
    }
    public baseMetaData(String typeCollection){
        this.typeCollection = typeCollection;
        initDate = new Date();
        size = 0;
    }
    public void updMetaData(LinkedList<?> coll){
        size = coll.size();
    }
}
