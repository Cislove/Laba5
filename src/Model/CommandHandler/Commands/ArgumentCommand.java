package Model.CommandHandler.Commands;


public interface ArgumentCommand {
    Pair<Integer, String> execute(String arguments);
    void update();
}
