import Model.CommandHandler.Commands.Command;
import Model.CommandHandler.Commands.CommandsList;
import Model.CommandHandler.Commands.HelpCommand;
import Model.CommandHandler.Commands.InfoCommand;
import Model.CommandHandler.Switcher;
import Model.EntryBlock;
import Model.Storage.Storage;

public class Main {
    public static void main(String[] args) {
        EntryBlock model = new EntryBlock();
        System.out.println(model.execute("info"));
        System.out.println(model.execute("help"));
        System.out.println(model.execute("show"));
        /*
        CommandsList list = new CommandsList();
        list.register("help", "вывести справку по доступным командам");
        list.register("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        Storage st = new Storage();
        Command infoCommand = new InfoCommand(st);
        Command helpCommand = new HelpCommand(list);
        Switcher sw = new Switcher();
        sw.CommandsRegister("info", infoCommand);
        sw.CommandsRegister("help", helpCommand);
        System.out.println(sw.execute("info"));
        System.out.println(sw.execute("help"));
         */
    }
}