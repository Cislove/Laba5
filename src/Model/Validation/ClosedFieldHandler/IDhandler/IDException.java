package Model.Validation.ClosedFieldHandler.IDhandler;

public class IDException extends Exception{
    String message;
    public IDException(String message){
        this.message = message;
    }
    public IDException(){

    }

    public String getMessage(){
        return message;
    }
}
