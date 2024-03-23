package Model.Storage.StorageObject;

import Model.Storage.StorageObject.ValidationBlock.ValidateException;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class StudyGroup {
    @closedField
    private Integer id = -1; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name = "test"; //Поле не может быть null, Строка не может быть пустой
    @fieldWithCompoundInput
    private Coordinates coordinates = new Coordinates(); //Поле не может быть null
    @closedField
    private java.time.LocalDate creationDate = LocalDate.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long studentsCount = 10L; //Значение поля должно быть больше 0
    @enumType
    @mayBeNull
    private FormOfEducation formOfEducation = FormOfEducation.FULL_TIME_EDUCATION; //Поле может быть null
    @enumType
    @mayBeNull
    private Semester semesterEnum = Semester.FIFTH; //Поле может быть null
    @fieldWithCompoundInput
    @mayBeNull
    private Person groupAdmin = new Person(); //Поле может быть null
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public long getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Long studentsCount) {
        this.studentsCount = studentsCount;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    @Override
    public String toString() {
        String response = "Характеристики группы: " + "\n";
        response += ("  " + "ID " + id.toString() + "\n");
        response += ("  " + "Название " + name + "\n");
        response += ("  " + "Координаты: " + coordinates.toString() + "\n");
        response += ("  " + "Дата создания " + creationDate + "\n");
        response += ("  " + "Количество студентов " + studentsCount + "\n");
        if(formOfEducation != null)
            response += ("  " + "Форма обучения " + formOfEducation.toString() + "\n");
        if(semesterEnum != null)
            response += ("  " + "Тип семестра " + semesterEnum.toString() + "\n");
        if(groupAdmin != null)
            response += ("  " + "Староста: " +  groupAdmin.toString());
        return response;
    }
    public String parseName(String name) throws ValidateException {
        if(name.isEmpty()){
            throw new ValidateException("У группы обязательно должно быть имя!\n");
        }
        return name;
    }
}
