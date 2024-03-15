package Model.Storage.StorageObject;

import java.time.ZonedDateTime;

public class StudyGroup {
    @closedField
    private Integer id = -1; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name = "test"; //Поле не может быть null, Строка не может быть пустой
    @fieldWithCompoundInput
    private Coordinates coordinates = new Coordinates(); //Поле не может быть null
    @closedField
    private java.time.ZonedDateTime creationDate = ZonedDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long studentsCount = 10L; //Значение поля должно быть больше 0, поле может быть null
    @enumType
    private FormOfEducation formOfEducation = FormOfEducation.FULL_TIME_EDUCATION; //Поле может быть null
    @enumType
    private Semester semesterEnum = Semester.FIFTH; //Поле не может быть null
    @fieldWithCompoundInput
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

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public long getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(long studentsCount) {
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
        response += ("  " + "Форма обучения " + semesterEnum.toString() + "\n");
        response += ("  " + "Тип семестра " + formOfEducation.toString() + "\n");
        response += ("  " + "Староста: " +  groupAdmin.toString());
        return response;
    }
}
