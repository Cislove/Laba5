package Model.Storage;
import Model.Storage.StorageObject.*;
import Model.Storage.ObjectDescription.baseMetaData;

import java.util.LinkedList;

public class Storage implements IStorage {
    private LinkedList<StudyGroup> collection;
    private baseMetaData mDATA;
    public Storage(){
        collection = new LinkedList<>();
        mDATA = new baseMetaData("LinkedList");
    }

    public LinkedList<StudyGroup> getCollection() {
        return collection;
    }
    public int addElement(StudyGroup el){
        collection.add(el);
        return 0;
    }
    public int delElement(int id){
        collection.remove(id);
        return 0;
    }
    public int updElement(int id, StudyGroup el){
        collection.set(id, el);
        return 0;
    }
    public StudyGroup getElement(int id){
        StudyGroup el = collection.get(id);
        return el;
    }
    public LinkedList <StudyGroup> getAllElements(){
        LinkedList <StudyGroup> coll = collection;
        return coll;
    }
    public int clear(){
        collection.clear();
        return 0;
    }
    public baseMetaData getmData(){
        mDATA.updMetaData(collection);
        return mDATA;
    }
}
