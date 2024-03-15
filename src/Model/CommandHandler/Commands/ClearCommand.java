package Model.CommandHandler.Commands;

import Model.Storage.IStorage;

public class ClearCommand implements Command{
    IStorage storage;
    public ClearCommand(IStorage storage){
        this.storage = storage;
    }
    @Override
    public Pair<Integer, String> execute() {
        storage.clear();
        return new Pair<>(0, "Коллекция успешно очищена\n");
    }
}
