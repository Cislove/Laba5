package Model.CommandHandler.Commands;

import java.util.ArrayList;

public class CommandsList {
    private ArrayList<Pair<String, String>> list;
    public CommandsList(){
        list = new ArrayList<>();
    }

    public ArrayList<Pair<String, String>> getList() {
        return list;
    }

    public void setList(ArrayList<Pair<String, String>> list) {
        this.list = list;
    }
    public void register(String command, String description){
        list.add(new Pair<String, String>(command, description));
    }
}
