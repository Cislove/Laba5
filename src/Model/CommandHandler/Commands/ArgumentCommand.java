package Model.CommandHandler.Commands;

import java.util.ArrayList;

public interface ArgumentCommand {
    public Pair<Integer, String> execute(String arguments);
}
