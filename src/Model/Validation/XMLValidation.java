package Model.Validation;

import Model.Storage.IStorage;

import java.time.LocalDate;

public class XMLValidation extends Validator{
    IDHandler idHandler;
    public XMLValidation(IStorage storage, IDHandler idHandler) {
        super(storage);
        this.idHandler = idHandler;
    }
    public boolean StudyGroupIDValidation(Long id)throws ValidateException{
        try {
            if(id == null){
                throw new ValidateException("ID должен быть числом\n");
            }
            idHandler.setId(Integer.parseInt(String.valueOf(id)));
        }
        catch (IDException e){
            throw new ValidateException("Данный ID уже занят\n");
        }
        return true;
    }
    public boolean StudyGroupCreationDateValidation(LocalDate creationDate)throws ValidateException{
        if(creationDate == null){
            throw new ValidateException("У группы отсутствует дата создания\n");
        }
        return true;
    }
}
