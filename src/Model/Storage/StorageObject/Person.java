package Model.Storage.StorageObject;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class Person {
    private String name = "Коля"; //Поле не может быть null, Строка не может быть пустой
    private java.time.ZonedDateTime birthday = ZonedDateTime.now();; //Поле не может быть null
    private Double height = 180.; //Поле не может быть null, Значение поля должно быть больше 0
    private Double weight = 80.; //Пое не может быть null, Значение поля должно быть больше 0
    private String passportID = "123456789"; //Длина строки должна быть не меньше 9, Значение этого поля должно быть уникальным, Длина строки не должна быть больше 31, Поле не может быть null

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    @Override
    public String toString() {
        String response = "\n";
        response += ("      " + "Имя " + name + "\n");
        response += ("      " + "День рождения " + birthday + "\n");
        response += ("      " + "Рост " + height + "\n");
        response += ("      " + "Вес " + weight + "\n");
        response += ("      " + "ID паспорта " + passportID);
        return response;
    }
}
