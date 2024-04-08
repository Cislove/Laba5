package Model.Validation;

import Model.Storage.IStorage;
import Model.Storage.StorageObject.FormOfEducation;
import Model.Storage.StorageObject.Semester;

import java.time.LocalDate;

public class Validator {
    IStorage storage;
    public Validator(IStorage storage){
        this.storage = storage;
    }
    public boolean StudyGroupNameValidation(String name) throws ValidateException{
        nullChecker(name);
        if(name.isEmpty()){
            throw new ValidateException("У группы обязательно должно быть имя!\n");
        }
        return true;
    }
    public boolean StudyGroupStudentsCountValidation(Long studentsCount) throws ValidateException{
        nullChecker(studentsCount);
        if(studentsCount <= 0L){
            throw new ValidateException("Количество людей в группе обязательно должно быть больше нуля!\n");
        }
        return true;
    }
    public boolean StudyGroupFormOfEducationValidation(FormOfEducation formOfEducation) throws ValidateException{
        //nullChecker(formOfEducation);
        return true;
    }
    public boolean StudyGroupSemesterEnumValidation(Semester semesterEnum) throws ValidateException{
        //nullChecker(semesterEnum);
        return true;
    }
    public boolean CoordinatesXCordValidation(Float xCord) throws ValidateException{
        nullChecker(xCord);
        if(xCord <= -407f){
            throw new ValidateException("Значение координаты X должно быть больше -407\n");
        }
        return true;
    }
    public boolean CoordinatesYCordValidation(Float yCord) throws ValidateException{
        nullChecker(yCord);
        return true;
    }
    public boolean PersonNameValidation(String name) throws ValidateException{
        if(name.isEmpty()){
            throw new ValidateException("У человека обязательно должно быть имя!\n");
        }
        return true;
    }
    public boolean PersonBirthdayValidation(LocalDate birthday) throws ValidateException{
        nullChecker(birthday);
        return true;
    }
    public boolean PersonHeightValidation(Double height) throws ValidateException{
        nullChecker(height);
        if(height <= 0){
            throw new ValidateException("значение роста должно быть большие нуля!\n");
        }
        return true;
    }
    public boolean PersonWeightValidation(Double weight) throws ValidateException{
        nullChecker(weight);
        if(weight <= 0){
            throw new ValidateException("значение веса должно быть больше нуля!\n");
        }
        return true;
    }
    public boolean PersonPassportIDValidation(String id) throws ValidateException{
        nullChecker(id);
        if(id.length() < 9 || id.length() > 31){
            throw new ValidateException("Длина номера паспорта должна быть не менее 9 и не более 31\n");
        }
        if(storage.checkPassportId(id)){
            throw new ValidateException("Номер паспорта должен быть уникальным!\n");
        }
        return true;
    }
    public void nullChecker(Object o) throws ValidateException {
        if(o == null){
            throw new ValidateException("Нет обязательной информации\n");
        }
    }
}
