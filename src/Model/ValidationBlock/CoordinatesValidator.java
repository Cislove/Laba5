package Model.ValidationBlock;

import Model.Storage.StorageObject.Coordinates;
import Model.Storage.StorageObject.StudyGroup;

public class CoordinatesValidator {
    public static Float XValidation(String XCord) throws ValidateException{
        Float ans;
        try {
            ans = Float.parseFloat(XCord);
        }
        catch (NumberFormatException e){
            throw new ValidateException("Значение координаты X должно быть числом");
        }
        if(ans <= -407f){
            throw new ValidateException("Значение координаты X должно быть больше -407");
        }
        return ans;
    }
    public static Float YValidation(String YCord) throws ValidateException{
        Float ans;
        try {
            ans = Float.parseFloat(YCord);
        }
        catch (NumberFormatException e){
            throw new ValidateException("Значение координаты Y должно быть числом");
        }
        return ans;
    }
}
