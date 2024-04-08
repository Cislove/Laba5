package Model.CommandHandler.Commands;

import java.util.ArrayList;

public class CommandsList {
    private final ArrayList<Pair<String, String>> list;
    public CommandsList(){
        list = new ArrayList<>();
    }

    public ArrayList<Pair<String, String>> getList() {
        return list;
    }

    public void register(String command, String description){
        list.add(new Pair<>(command, description));
    }
}
