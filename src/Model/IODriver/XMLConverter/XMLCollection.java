package Model.IODriver.XMLConverter;

import Model.Storage.ObjectDescription.baseMetaData;
import Model.Storage.StorageObject.StudyGroup;

import java.util.LinkedList;

public class XMLCollection {
    private LinkedList<StudyGroup> collection;
    private baseMetaData mDATA;
    public XMLCollection(){

    }
    public XMLCollection(LinkedList<StudyGroup> collection, baseMetaData mDATA){
        this.collection = collection;
        this.mDATA = mDATA;
    }

    public LinkedList<StudyGroup> getCollection() {
        return collection;
    }

    public void setCollection(LinkedList<StudyGroup> collection) {
        this.collection = collection;
    }

    public baseMetaData getmDATA() {
        return mDATA;
    }

    public void setmDATA(baseMetaData mDATA) {
        this.mDATA = mDATA;
    }
}
