package Model.ValidationBlock;

import Model.Storage.Storage;
import Model.Storage.StorageObject.Person;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.regex.Pattern;

public class PersonValidator {
    public static String nameValidation(String name) throws ValidateException{
        if(name.isEmpty()){
            throw new ValidateException("У человека обязательно должно быть имя!\n");
        }
        return name;
    }
    public static LocalDate birthdayValidation(String birthday) throws ValidateException{
        if(birthday.isEmpty()){
            throw new ValidateException("Дата рождения у человека обязательно должна быть!\n");
        }
        if(Pattern.matches("\\d{2}+.\\d{2}+.\\d{4}+", birthday)){
            return LocalDate.of(Integer.parseInt(birthday.substring(6, 10)),
                                Integer.parseInt(birthday.substring(3, 5)),
                                Integer.parseInt(birthday.substring(0, 2)));
        }
        else{
            throw new ValidateException("Дату рождения нужно вводить в формате: ДД.ММ.ГГГГ\n");
        }
    }
    public static Double heightValidation(String height) throws ValidateException{
        double ans;
        try {
            ans = Double.parseDouble(height);
        }
        catch (NumberFormatException e){
            throw new ValidateException("Значение роста должно быть числом!\n");
        }
        if(ans <= 0){
            throw new ValidateException("значение роста должно быть большие нуля!\n");
        }
        return ans;
    }
    public static Double weightValidation(String weight) throws ValidateException{
        double ans;
        try {
            ans = Double.parseDouble(weight);
        }
        catch (NumberFormatException e){
            throw new ValidateException("Значение веса должно быть числом!\n");
        }
        if(ans <= 0){
            throw new ValidateException("значение веса должно быть больше нуля!\n");
        }
        return ans;
    }
    public static String passportIDValidation(String id, Storage storage) throws ValidateException{
        if(id.isEmpty()){
            throw new ValidateException("У человека должен быть номер паспорта!\n");
        }
        if(id.length() < 9 || id.length() > 31){
            throw new ValidateException("Длина номера паспорта должна быть не менее 9 и не более 31\n");
        }
        if(!storage.checkPassportId(id)){
            throw new ValidateException("Номер паспорта должен быть уникальным!\n");
        }
        return id;
    }
}




