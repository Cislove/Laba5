package Model.Storage.StorageObject.ValidationBlock;

import java.lang.reflect.InvocationTargetException;

public class ValidateException extends InvocationTargetException {
    String message;
    public ValidateException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
