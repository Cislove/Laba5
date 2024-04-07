package Model.CommandHandler.Commands;

import Model.CommandHandler.Holders.ClosedFieldsHolder;
import Model.CommandHandler.Holders.FieldHolder;
import Model.Storage.IStorage;
import Model.Storage.StorageObject.StudyGroup;
import Model.Validation.ClosedFieldHandler.IDhandler.IDHandler;
import Model.Validation.Parser;
import Model.Validation.Validator;


public class AddCommand implements ArgumentCommand{
    private final IStorage storage;
    private final FieldHolder fieldHolder;
    private final ClosedFieldsHolder closedFieldsHolder;
    public AddCommand(IStorage storage, IDHandler idHandler){
        this.storage = storage;
        fieldHolder = new FieldHolder(new Validator(storage), new Parser());
        closedFieldsHolder = new ClosedFieldsHolder(idHandler);
    }
    @Override
    public Pair<Integer, String> execute(String arguments){
        Pair<Integer, String> response = fieldHolder.execute(arguments);
        if(response.getLeft() == 0){
            StudyGroup el = fieldHolder.getReadyEl();
            closedFieldsHolder.setFields(el);
            storage.addElement(el);
            response.setRight("Элеменет успешно добавлен\n");
            return response;
        }
        return response;
    }
}
