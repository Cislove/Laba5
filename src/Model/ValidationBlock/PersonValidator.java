package Model.ValidationBlock;

import Model.Storage.StorageObject.Person;
import java.time.ZonedDateTime;

public class PersonValidator {
    public static void getResponse(Person inst) throws ValidateException{
        nameValidation(inst.getName());
        birthdayValidation(inst.getBirthday());
        heightValidation(inst.getHeight());
        weightValidation(inst.getWeight());
    }
    private static void nameValidation(String name) throws ValidateException{
        if(name.equals("")){
            throw new ValidateException("поле \"name\" не может быть пустым");
        }
    }
    private static void birthdayValidation(ZonedDateTime birthday) throws ValidateException{
        return;
    }
    private static void heightValidation(Double height) throws ValidateException{
        if(height <= 0){
            throw new ValidateException("значения поля должно быть числом большим нуля");
        }
    }
    private static void weightValidation(Double weight) throws ValidateException{
        heightValidation(weight);
    }
}




