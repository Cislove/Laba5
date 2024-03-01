package Model.CommandHandler.Commands;

public class HelpCommand implements Command{
    CommandsList list;
    public HelpCommand(CommandsList list){
        this.list = list;
    }
    @Override
    public String execute() {
        String s = "";
        for(Pair<String, String> i: list.getList()){
            s += (i.getLeft() + ": " + i.getRight() + "\n");
        }
        return s;
    }

}