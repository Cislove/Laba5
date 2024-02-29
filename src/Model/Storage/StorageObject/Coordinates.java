
package Model.Storage.StorageObject;

public class Coordinates {
    private Float xCord; //Значение поля должно быть больше -407, Поле не может быть null
    private Float yCord; //Поле не может быть null

    public Float getxCord() {
        return xCord;
    }

    public void setxCord(Float xCord) {
        this.xCord = xCord;
    }

    public Float getyCord(){
        return yCord;
    }

    public void setyCord(Float yCord) {
        this.yCord = yCord;
    }
}
