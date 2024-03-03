package Model.ValidationBlock;

import Model.Storage.StorageObject.StudyGroup;

public class StudyGroupValidator {
    public static void getRequest(StudyGroup inst) throws ValidateException{
        nameValidation(inst.getName());
        CoordinatesValidator.getRequest(inst.getCoordinates());
        studentsCountValidation(inst.getStudentsCount());
        PersonValidator.getResponse(inst.getGroupAdmin());
    }
    private static void nameValidation(String name) throws ValidateException{
        if(name == null || name.isEmpty()){
            throw new ValidateException("\"name\" не может быть пустым");
        }
    }
    private static void studentsCountValidation(Long studentsCount) throws ValidateException{
        if(studentsCount <= 0){
            throw new ValidateException("значение \"studentsCount\" должно быть числом, большим нуля");
        }
    }
}
