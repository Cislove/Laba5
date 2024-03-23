package Model;

import Model.CommandHandler.Commands.*;
import Model.CommandHandler.Switcher;
import Model.Storage.Storage;

public class EntryBlock implements IModel{
    Switcher commandHandler;
    public String execute(String request){
        String response;
        response = commandHandler.execute(request);
        return response;
    }
    public String start(){
        Storage st = new Storage();
        CommandsList list = new CommandsList();
        list.register("help", "вывести справку по доступным командам");
        list.register("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        list.register("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        list.register("clear", "очистить коллекцию");
        list.register("remove_first", "удалить первый элемент из коллекции");
        list.register("head", "вывести первый элемент коллекции");
        list.register("exit", "завершить программу (без сохранения в файл)");
        list.register("add", "добавить новый элемент в коллекцию");
        Command infoCommand = new InfoCommand(st);
        Command helpCommand = new HelpCommand(list);
        Command showCommand = new ShowCommand(st);
        Command clearCommand = new ClearCommand(st);
        Command removeFirstCommand = new removeFirstCommand(st);
        Command headCommand = new HeadCommand(st);
        Command exitCommand = new ExitCommand();
        System.out.println("1");
        ArgumentCommand addCommand = new AddCommand(st);
        System.out.println("2");
        commandHandler = new Switcher();
        commandHandler.CommandsRegister("info", infoCommand);
        commandHandler.CommandsRegister("help", helpCommand);
        commandHandler.CommandsRegister("show", showCommand);
        commandHandler.CommandsRegister("clear", clearCommand);
        commandHandler.CommandsRegister("remove_first", removeFirstCommand);
        commandHandler.CommandsRegister("head", headCommand);
        commandHandler.CommandsRegister("exit", exitCommand);
        commandHandler.ArgumentCommandsRegister("add", addCommand);
        return "Добро пожаловать в программу!!!\n";
    }
}
