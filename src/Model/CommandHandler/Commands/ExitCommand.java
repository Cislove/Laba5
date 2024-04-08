package Model.CommandHandler.Commands;

public class ExitCommand implements Command{
    @Override
    public Pair<Integer, String> execute() {
        return new Pair<>(-1, "Программа завершила работу\n");
    }
}
