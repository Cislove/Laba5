package Model.CommandHandler.Holders;

import Model.Storage.StorageObject.StudyGroup;
import Model.Validation.IDHandler;

public class ClosedFieldsHolder {
    IDHandler idHandler;
    public ClosedFieldsHolder(IDHandler idHandler){
        this.idHandler = idHandler;
    }
    public void setFields(StudyGroup el){
        el.setId(Long.valueOf(idHandler.getFreeId()));
        el.setCreationDate();
    }
}
