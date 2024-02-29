package Model.Storage.ObjectDescription;


import java.util.LinkedList;

public class baseMetaData {
    public java.util.Date initDate;
    public String typeCollection;
    public int size;
    public baseMetaData(String typeCollection){
        this.typeCollection = typeCollection;
        size = 0;
    }
    public void updMetaData(LinkedList<?> coll){
        size = coll.size();
    }
}
