package Model;

import Model.CommandHandler.Commands.*;
import Model.CommandHandler.Switcher;
import Model.IODriver.IOHandler;
import Model.IODriver.Reader.Reader;
import Model.IODriver.Writter.Writter;
import Model.Storage.Storage;
import Model.Storage.StorageObject.StudyGroup;
import Model.Validation.ClosedFieldHandler.IDhandler.IDException;
import Model.Validation.ClosedFieldHandler.IDhandler.IDHandler;
import Model.Validation.ValidateException;
import Model.Validation.XMLValidation;

import java.io.IOException;

public class EntryBlock implements IModel{
    Switcher commandHandler;
    public String execute(String request){
        String response;
        response = commandHandler.execute(request);
        return response;
    }
    private String writeList(Storage st, IOHandler ioHandler, IDHandler idHandler, String path){
        //System.out.println(collection);
        int idEl = 1;
        try {
            XMLValidation validator = new XMLValidation(st, idHandler);
            //validator.CoordinatesYCordValidation(null);
            //validator.StudyGroupStudentsCountValidation(null);
            XMLCollection collection = ioHandler.readListFromFile(path);
            //System.out.println("popa1");
            for(StudyGroup el: collection.getCollection()){
                System.out.println(el.getStudentsCount());
                //System.out.println("popa2");
                validator.StudyGroupIDValidation(el.getId());
                //System.out.println("popa3");
                validator.StudyGroupNameValidation(el.getName());
                validator.CoordinatesXCordValidation(el.getCoordinates().getXCord());
                validator.CoordinatesYCordValidation(el.getCoordinates().getYCord());
                //System.out.println(el.getCoordinates().getYCord());
                validator.StudyGroupCreationDateValidation(el.getCreationDate());
                validator.StudyGroupStudentsCountValidation(el.getStudentsCount());
                if(el.getGroupAdmin() != null){
                    validator.PersonNameValidation(el.getGroupAdmin().getName());
                    validator.PersonBirthdayValidation(el.getGroupAdmin().getBirthday());
                    validator.PersonHeightValidation(el.getGroupAdmin().getHeight());
                    validator.PersonWeightValidation(el.getGroupAdmin().getWeight());
                    validator.PersonPassportIDValidation(el.getGroupAdmin().getPassportID());
                }
                st.addElement(el);
                idEl++;
            }
            //st.setCollection(collection.getCollection());
            st.setmData(collection.getmDATA());
        }
        catch (ValidateException | NullPointerException e){
            return "Ошибка загрузки данных из файла\n" + idEl + " элемент: " + e.getMessage();
        }
        catch (IOException e){
            return "Ошибка загрузки данных из файла\n" + e.getMessage();
        }
        return "Данные из файла успешно загружены\n";
//        st.setCollection(collection.getCollection());
//        st.setmData(collection.getmDATA());
    }
    public String start(){
        String response = "Добро пожаловать в программу!!!\n";
        Storage st = new Storage();
        Reader r = new Reader();
        Writter w = new Writter();
        IDHandler idHandler = new IDHandler();
        IOHandler ioHandler = new IOHandler(r, w);
        CommandsList list = new CommandsList();
        list.register("help", "вывести справку по доступным командам");
        list.register("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        list.register("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        list.register("add {element}", "добавить новый элемент в коллекцию");
        list.register("update id {element}", "обновить значение элемента коллекции, id которого равен заданному");
        list.register("remove_by_id id", "удалить элемент из коллекции по его id");
        list.register("clear", "очистить коллекцию");
        list.register("save", "сохранить коллекцию в файл");
        list.register("exit", "завершить программу (без сохранения в файл)");
        list.register("remove_first", "удалить первый элемент из коллекции");
        list.register("head", "вывести первый элемент коллекции");
        list.register("add_if_min {element}", "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        list.register("min_by_group_admin", "вывести любой объект из коллекции, значение поля groupAdmin которого является минимальным");
        list.register("group_counting_by_id", "сгруппировать элементы коллекции по значению поля id, вывести количество элементов в каждой группе");
        list.register("filter_contains_name name", "вывести элементы, значение поля name которых содержит заданную подстроку");
        Command helpCommand = new HelpCommand(list);
        Command infoCommand = new InfoCommand(st);
        Command showCommand = new ShowCommand(st);
        Command clearCommand = new ClearCommand(st);
        Command saveCommand = new SaveCommand(st, ioHandler);
        Command exitCommand = new ExitCommand();
        Command removeFirstCommand = new removeFirstCommand(st);
        Command headCommand = new HeadCommand(st);
        Command minByGroupAdmin = new MinByGroupAdmin(st);
        Command groupCountingById = new GroupCountingByidCommand(st);
        //System.out.println("1");
        ArgumentCommand addCommand = new AddCommand(st, idHandler);
        ArgumentCommand updCommand = new UpdateCommand(st, idHandler);
        ArgumentCommand removeByIdCommand = new RemoveByIdCommand(st, idHandler);
        ArgumentCommand addIfMin = new AddIfMinCommand(st, idHandler);
        ArgumentCommand filterContainsName = new FilterContainsNameCommand(st);
        //System.out.println("2");
        commandHandler = new Switcher();
        commandHandler.CommandsRegister("help", helpCommand);
        commandHandler.CommandsRegister("info", infoCommand);
        commandHandler.CommandsRegister("show", showCommand);
        commandHandler.CommandsRegister("clear", clearCommand);
        commandHandler.CommandsRegister("save", saveCommand);
        commandHandler.CommandsRegister("exit", exitCommand);
        commandHandler.CommandsRegister("remove_first", removeFirstCommand);
        commandHandler.CommandsRegister("head", headCommand);
        commandHandler.CommandsRegister("min_by_group_admin", minByGroupAdmin);
        commandHandler.CommandsRegister("group_counting_by_id", groupCountingById);
        commandHandler.ArgumentCommandsRegister("add", addCommand);
        commandHandler.ArgumentCommandsRegister("update", updCommand);
        commandHandler.ArgumentCommandsRegister("remove_by_id", removeByIdCommand);
        commandHandler.ArgumentCommandsRegister("add_if_min", addIfMin);
        commandHandler.ArgumentCommandsRegister("filter_contains_name", filterContainsName);
        response += writeList(st, ioHandler, idHandler, "ProgramFile/Main.xml");
        //writeList(st, ioHandler.readListFromFile("ProgramFile/Main.xml"));
        return response;
    }
}
