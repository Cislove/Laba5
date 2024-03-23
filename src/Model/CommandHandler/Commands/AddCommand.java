package Model.CommandHandler.Commands;

import Model.Storage.IStorage;
import Model.Storage.StorageObject.ValidationBlock.Validator;


public class AddCommand implements ArgumentCommand{
    private final IStorage storage;
    private final PlaceHolder p;
    public AddCommand(IStorage storage){
        this.storage = storage;
        p = new PlaceHolder(new Validator(storage));
    }
    @Override
    public Pair<Integer, String> execute(String arguments){
        Pair<Integer, String> response = p.execute(arguments);
        if(response.getLeft() == 0){
            storage.addElement(p.getReadyEl());
            response.setRight("Элеменет успешно добавлен\n");
            return response;
        }
        return response;
    }
}
