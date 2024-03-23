package Model.Storage;
import Model.Storage.StorageObject.*;
import Model.Storage.ObjectDescription.baseMetaData;

import java.util.HashMap;
import java.util.LinkedList;

public class Storage implements IStorage {
    private LinkedList<StudyGroup> collection;
    private baseMetaData mDATA;
    private HashMap<String, Boolean> passportIdStorage;
    public Storage(){
        collection = new LinkedList<>();
        mDATA = new baseMetaData("LinkedList");
        //collection.add(new StudyGroup());
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
        collection.remove(id);
        passportIdStorage.remove(collection.get(id).getGroupAdmin().getPassportID());
        return 0;
    }
    public int updElement(int id, StudyGroup el){
        collection.set(id, el);
        passportIdStorage.put(el.getGroupAdmin().getPassportID(), true);
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
