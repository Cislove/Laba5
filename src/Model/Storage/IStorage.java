package Model.Storage;

import Model.Storage.ObjectDescription.baseMetaData;
import Model.Storage.StorageObject.StudyGroup;

import java.util.LinkedList;

public interface IStorage {
    public int addElement(StudyGroup el);
    public int delElement(int id);
    public int updElement(int id, StudyGroup el);
    public StudyGroup getElement(int id);
    public LinkedList<StudyGroup> getAllElements();
    public int clear();
    public baseMetaData getmData();
}
