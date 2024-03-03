package Model;

import Model.CommandHandler.Commands.Command;
import Model.CommandHandler.Commands.CommandsList;
import Model.CommandHandler.Commands.HelpCommand;
import Model.CommandHandler.Commands.InfoCommand;
import Model.CommandHandler.Switcher;
import Model.Storage.Storage;

public class EntryBlock implements IModel{
    Switcher commandHandler;
    public EntryBlock(){
        Storage st = new Storage();
        CommandsList list = new CommandsList();
        list.register("help", "вывести справку по доступным командам");
        list.register("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        Command infoCommand = new InfoCommand(st);
        Command helpCommand = new HelpCommand(list);
        commandHandler = new Switcher();
        commandHandler.CommandsRegister("info", infoCommand);
        commandHandler.CommandsRegister("help", helpCommand);
    }
    public String execute(String request){
        String response;
        response = commandHandler.execute(request);
        return response;
    }
}
