package Model.Storage.StorageObject.ValidationBlock;

import Model.Storage.IStorage;
import Model.Storage.Storage;
import Model.Storage.StorageObject.FormOfEducation;
import Model.Storage.StorageObject.Semester;
import Model.Storage.StorageObject.StudyGroup;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Validator {
    IStorage storage;
    public Validator(IStorage storage){
        this.storage = storage;
    }
    public String StudyGroupNameValidation(String name) throws ValidateException{
        if(name.isEmpty()){
            throw new ValidateException("У группы обязательно должно быть имя!\n");
        }
        return name;
    }
    public Long StudyGroupStudentsCountValidation(String studentsCount) throws ValidateException{
        try{
            Long ans = Long.parseLong(studentsCount);
            if(ans <= 0L){
                throw new ValidateException("Количество людей в группе обязательно должно быть больше нуля!\n");
            }
            return ans;
        }
        catch (NumberFormatException e){
            throw new ValidateException("Количество людей в группе должно быть числом!\n");
        }
    }
    public FormOfEducation StudyGroupFormOfEducationValidation(String formOfEducation) throws ValidateException{
        try {
            return FormOfEducation.valueOf(formOfEducation);
        }
        catch (IllegalArgumentException e) {
            throw new ValidateException("Тип обучения группы должен быть обязательно одним из предложенных!\n");
        }
    }
    public Semester StudyGroupSemesterEnumValidation(String semesterEnum) throws ValidateException{
        try {
            return Semester.valueOf(semesterEnum);
        }
        catch (IllegalArgumentException e){
            throw new ValidateException("Тип семестра у группы должен быть одним из предложенных!\n");
        }
    }
    public Float CoordinatesXCordValidation(String XCord) throws ValidateException{
        Float ans;
        try {
            ans = Float.parseFloat(XCord);
        }
        catch (NumberFormatException e){
            throw new ValidateException("Значение координаты X должно быть числом\n");
        }
        if(ans <= -407f){
            throw new ValidateException("Значение координаты X должно быть больше -407\n");
        }
        return ans;
    }
    public Float CoordinatesYCordValidation(String YCord) throws ValidateException{
        Float ans;
        try {
            ans = Float.parseFloat(YCord);
        }
        catch (NumberFormatException e){
            throw new ValidateException("Значение координаты Y должно быть числом\n");
        }
        return ans;
    }
    public String PersonNameValidation(String name) throws ValidateException{
        if(name.isEmpty()){
            throw new ValidateException("У человека обязательно должно быть имя!\n");
        }
        return name;
    }
    public LocalDate PersonBirthdayValidation(String birthday) throws ValidateException{
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
    public Double PersonHeightValidation(String height) throws ValidateException{
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
    public Double PersonWeightValidation(String weight) throws ValidateException{
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
    public String PersonPassportIDValidation(String id) throws ValidateException{
        if(id.isEmpty()){
            throw new ValidateException("У человека должен быть номер паспорта!\n");
        }
        if(id.length() < 9 || id.length() > 31){
            throw new ValidateException("Длина номера паспорта должна быть не менее 9 и не более 31\n");
        }
        if(storage.checkPassportId(id)){
            throw new ValidateException("Номер паспорта должен быть уникальным!\n");
        }
        return id;
    }
}
