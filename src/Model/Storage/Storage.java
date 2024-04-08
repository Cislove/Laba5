package Model.Storage;
import Model.Storage.StorageObject.*;
import Model.Storage.ObjectDescription.baseMetaData;

import java.util.HashMap;
import java.util.LinkedList;

public class Storage implements IStorage {
    private LinkedList<StudyGroup> collection;
    private baseMetaData mDATA;
    private final HashMap<String, Boolean> passportIdStorage;
    public Storage(){
        collection = new LinkedList<>();
        mDATA = new baseMetaData("LinkedList");
        passportIdStorage = new HashMap<>();
    }

    public LinkedList<StudyGroup> getCollection() {
        return collection;
    }
    public int addElement(StudyGroup el){
        collection.add(el);
        if(el.getGroupAdmin() != null) {
            passportIdStorage.put(el.getGroupAdmin().getPassportID(), true);
        }
        return 0;
    }
    public int delElement(int id){
        if(collection.get(id).getGroupAdmin() != null) {
            passportIdStorage.replace(collection.get(id).getGroupAdmin().getPassportID(), true);
        }
        collection.remove(id);
        return 0;
    }
    public int updElement(int id, StudyGroup el){
        collection.set(id, el);
        if(el.getGroupAdmin() != null) {
            passportIdStorage.replace(el.getGroupAdmin().getPassportID(), true);
        }
        return 0;
    }
    public StudyGroup getElement(int id){
        return collection.get(id);
    }
    public LinkedList <StudyGroup> getAllElements(){
        return collection;
    }
    public int clear(){
        collection.clear();
        return 0;
    }
    public baseMetaData getmData(){
        mDATA.updMetaData(collection);
        return mDATA;
    }
    public void setmData(baseMetaData mDATA){
        this.mDATA = mDATA;
    }
    public void setCollection(LinkedList<StudyGroup> list){
        collection = list;
    }
    private void delPassportId(String passportId){
        passportIdStorage.remove(passportId);
    }
    private void addPassportId(String passportId){
        passportIdStorage.put(passportId, true);
    }
    public boolean checkPassportId(String passportId){
        return passportIdStorage.containsKey(passportId);
    }
}
