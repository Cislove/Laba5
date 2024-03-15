package Model.CommandHandler.Commands;

import Model.Storage.IStorage;
import Model.Storage.StorageObject.StudyGroup;
import Model.Storage.StorageObject.closedField;
import Model.Storage.StorageObject.enumType;
import Model.Storage.StorageObject.fieldWithCompoundInput;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class AddCommand implements ArgumentCommand{
    private IStorage storage;
    private StudyGroup cash;
    private int id;
    private int max_id;
    private Stack <Field> fields;
    private Stack <Field> lastFields;
    private boolean flag;
    public AddCommand(IStorage storage){
        this.storage = storage;
        cash = new StudyGroup();
        id = 0;
        Collections.addAll(fields, cash.getClass().getDeclaredFields());
        checkField();
    }
    private void finish(){
        storage.addElement(cash);
        id = 0;
        cash = new StudyGroup();
        fields = new Stack<>();
        Collections.addAll(fields, cash.getClass().getDeclaredFields());
        checkField();
    }
    @Override
    public Pair<Integer, String> execute(String arguments){
        System.out.println(arguments);
        String response;
        if(arguments != null){
            writeField(arguments);
        }
        if(checkField()){
            response = "Введите поле " + fields.peek().getName();
            if(fields.peek().isEnumConstant()){
                response += ("(" + fields.peek().getType().getEnumConstants() + ")");
            }
            if(fields.peek().getAnnotation(fieldWithCompoundInput.class) != null){
                response = "Вы хотите ввести поле " + fields.peek().getName() + "?(введите yes/no)";
            }
            lastFields.push(fields.pop());
            return new Pair<>(1, response + "\n");
        }
        finish();
        return new Pair<>(0, "Экземпляр успешно добавлен в коллекцию");
        /*
        if(arguments != null){
            try {
                System.out.println("set" + fields[id - 1].getName().substring(0, 1).toUpperCase() + fields[id - 1].getName().substring(1));
                Method method = cash.getClass().getDeclaredMethod(
                         "set" +
                                 fields[id - 1].getName().substring(0, 1).toUpperCase() +
                                 fields[id - 1].getName().substring(1), String.class);
                System.out.println(method);
                method.invoke(cash, arguments);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                System.out.println("чет не то пошло");
                System.exit(1);
            }
        }
        */
        id++;
        System.out.println(0);
        return new Pair<>(1, response);
    }
    private boolean checkField(){
        while(!fields.empty()){
            if(fields.peek().getAnnotation(closedField.class) == null){
                return true;
            }
        }
        return false;
    }
    private String writeField(String arguments){
        try {
            Method method = cash.getClass().getDeclaredMethod(
                            "set" +
                            lastFields.peek().getName().substring(0, 1).toUpperCase() +
                            lastFields.peek().getName().substring(1), lastFields.peek().getType());
            //System.out.println(method);
            method.invoke(cash, );
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("чет не то пошло");
            System.exit(1);
        }
        lastFields.pop();
    }
    /*
    private <E> ArrayList <Field> getField(Class<E> inst){
        ArrayList <Field> ans = new ArrayList<>();
        Field[] fields = inst.getClass().getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            if(fields[i].getAnnotation(fieldWithCompoundInput.class) != null){
                ans += getField()
            }
        }
    }
     */
    /*
    @Override
    public Pair<Integer, String> execute(String arguments) {
        String response = "";
        cash = new StudyGroup();
        switch (id){
            case(0):
                response = "Введите название группы\n";
                break;
            case(1):
                try{
                    cash.setName(StudyGroupValidator.nameValidation(arguments));
                    id++;
                    response = "Введите координату X для группы\n";
                }
                catch (ValidateException e){
                    response = e.getMessage();
                }
                break;
            case(2):
                try{
                    cash.getCoordinates().setxCord(CoordinatesValidator.XValidation(arguments));
                    id++;
                    response = "Введите координату Y для группы\n";
                }
                catch (ValidateException e){
                    response = e.getMessage();
                }
                break;
            case(3):
                try{
                    cash.getCoordinates().setyCord(CoordinatesValidator.YValidation(arguments));
                    id++;
                    response = "Введите количество студентов в группе\n";
                }
                catch (ValidateException e){
                    response = e.getMessage();
                }
                break;
            case(4):
                try{
                    cash.setStudentsCount(StudyGroupValidator.studentsCountValidation(arguments));
                    id++;
                    response = "У группы есть форма обучения?(введите \"yes\", если да и \"no\", если нет\n";
                }
                catch (ValidateException e){
                    response = e.getMessage();
                }
                break;
            case(5):
                if(arguments.equals("yes")){
                    id++;
                    response = "";
                    break;
                }
                if(arguments.equals("no")){
                    id += 2;
                    break;
                }
                response = "У группы есть форма обучения?(введите \"yes\", если да и \"no\", если нет\n";
                break;
            case(6):

                break;
            case(7):

        }
        return new Pair<>(1, response);
    }

    private void restart(){
        id = 0;
    }
     */
}
