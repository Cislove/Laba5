package Model.CommandHandler.Commands;

import Model.CommandHandler.Holders.ClosedFieldsHolder;
import Model.CommandHandler.Holders.FieldHolder;
import Model.Storage.IStorage;
import Model.Storage.StorageObject.StudyGroup;
import Model.Validation.ClosedFieldHandler.IDhandler.IDHandler;
import Model.Validation.Parser;
import Model.Validation.Validator;

public class AddIfMinCommand implements ArgumentCommand{
    private final IStorage storage;
    private final FieldHolder fieldHolder;
    private final ClosedFieldsHolder closedFieldsHolder;
    public AddIfMinCommand(IStorage storage, IDHandler idHandler){
        this.storage = storage;
        fieldHolder = new FieldHolder(new Validator(storage), new Parser());
        closedFieldsHolder = new ClosedFieldsHolder(idHandler);
    }
    @Override
    public Pair<Integer, String> execute(String arguments){
        Pair<Integer, String> response = fieldHolder.execute(arguments);
        if(response.getLeft() == 0){
            StudyGroup el = fieldHolder.getReadyEl();
            boolean flag = true;
            //if(storage.getAllElements().isEmpty()) flag = true;
            for(StudyGroup inst: storage.getAllElements()){
                if(inst.compareTo(el) <= 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                closedFieldsHolder.setFields(el);
                storage.addElement(el);
                response.setRight("Элемент успешно добавлен\n");
                return response;
            }
            response.setRight("К сожалению в памяти есть меньший элемент\n");
            return response;
        }
        return response;
    }
}
