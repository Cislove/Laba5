
package Model.Storage.StorageObject;

public class Coordinates {
    private Float xCord = 10F; //Значение поля должно быть больше -407, Поле не может быть null
    private Float yCord = 20F; //Поле не может быть null

    public Float getXCord() {
        return xCord;
    }

    public void setXCord(Float xCord) {
        this.xCord = xCord;
    }

    public Float getYCord(){
        return yCord;
    }

    public void setYCord(Float yCord) {
        this.yCord = yCord;
    }
    @Override
    public String toString() {
        String response = "\n";
        response += ("      " + "по оси X " + xCord.toString() + "\n");
        response += ("      " + "по оси Y " + yCord.toString());
        return response;
    }
}
