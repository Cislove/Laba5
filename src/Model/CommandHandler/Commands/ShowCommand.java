package Model.CommandHandler.Commands;

import Model.Storage.IStorage;
import Model.Storage.StorageObject.StudyGroup;

import java.util.LinkedList;

public class ShowCommand implements Command{
    IStorage storage;
    public ShowCommand(IStorage storage){
        this.storage = storage;
    }
    @Override
    public Pair<Integer, String> execute() {
        String response = "";
        LinkedList<StudyGroup> collection = storage.getAllElements();
        for(StudyGroup coll: collection){
            response += (coll.toString() + "\n");
        }
        return new Pair<>(0, response);
    }
}
