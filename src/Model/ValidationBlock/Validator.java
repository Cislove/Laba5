package Model.ValidationBlock;

import Model.Storage.StorageObject.FormOfEducation;
import Model.Storage.StorageObject.Semester;

public class Validator {
    public String nameValidation(String name) throws ValidateException{
        if(name.isEmpty()){
            throw new ValidateException("У группы обязательно должно быть имя!\n");
        }
        return name;
    }
    public Long studentsCountValidation(String studentsCount) throws ValidateException{
        try{
            Long ans = Long.parseLong(studentsCount);
            if(ans <= 0L){
                throw new ValidateException("Количество людей в группе обязательно должно быть больше нуля!\n");
            }
            return ans;
        }
        catch (NumberFormatException e){
            throw new ValidateException("Количество людей в группе должно быть числом!");
        }
    }
    public FormOfEducation formOfEducationValidation(String formOfEducation) throws ValidateException{
        try {
            return FormOfEducation.valueOf(formOfEducation);
        }
        catch (IllegalArgumentException e) {
            throw new ValidateException("Тип обучения группы должен быть обязательно одним из предложенных!");
        }
    }
    public Semester semesterEnumValidation(String semesterEnum) throws ValidateException{
        try {
            return Semester.valueOf(semesterEnum);
        }
        catch (IllegalArgumentException e){
            throw new ValidateException("Тип семестра у группы должен быть одним из предложенных!");
        }
    }
}
