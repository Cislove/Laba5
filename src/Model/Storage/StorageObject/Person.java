package Model.Storage.StorageObject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Date;

public class Person implements Comparable<Person>{
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private java.time.LocalDate birthday; //Поле не может быть null
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private Double height; //Поле не может быть null, Значение поля должно быть больше 0
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private Double weight; //Пое не может быть null, Значение поля должно быть больше 0
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String passportID; //Длина строки должна быть не меньше 9, Значение этого поля должно быть уникальным, Длина строки не должна быть больше 31, Поле не может быть null

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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
        response += ("\t\t" + "Имя " + name + "\n");
        response += ("\t\t" + "День рождения " + birthday + "\n");
        response += ("\t\t" + "Рост " + height + "\n");
        response += ("\t\t" + "Вес " + weight + "\n");
        response += ("\t\t" + "ID паспорта " + passportID);
        return response;
    }

    @Override
    public int compareTo(Person o) {
        int field;
        if((field = name.compareTo(o.getName())) != 0){
            return field;
        }
        if((field = birthday.compareTo(o.getBirthday())) != 0){
            return field;
        }
        if((field = height.compareTo(o.getHeight())) != 0){
            return field;
        }
        if((field = weight.compareTo(o.getWeight())) != 0){
            return field;
        }
        return 0;
    }
}
