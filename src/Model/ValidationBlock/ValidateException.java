package Model.ValidationBlock;

public class ValidateException extends Exception{
    String message;
    public ValidateException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
