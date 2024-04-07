package Model.Validation;

import Model.Storage.IStorage;
import Model.Storage.StorageObject.StudyGroup;
import Model.Validation.ClosedFieldHandler.IDhandler.IDException;
import Model.Validation.ClosedFieldHandler.IDhandler.IDHandler;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Stack;

import static java.util.Collections.reverse;

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
            idHandler.setId(Integer.valueOf(String.valueOf(id)));
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
