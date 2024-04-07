package Model.CommandHandler.Commands;

import Model.Storage.IStorage;
import Model.Storage.StorageObject.StudyGroup;

public class ExecuteScriptCommand implements ArgumentCommand{
    private final IStorage storage;
    public ExecuteScriptCommand(IStorage storage){
        this.storage = storage;
    }
    @Override
    public Pair<Integer, String> execute(String arguments){
        StringBuilder response = new StringBuilder();
        for(StudyGroup el: storage.getAllElements()){
            if(el.getName().contains(arguments)){
                response.append(el);
            }
        }
        if(response.isEmpty()){
            response.append("Таких элементов нет\n");
        }
        return new Pair<>(0, response.toString());
    }
}
