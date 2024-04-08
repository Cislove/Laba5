package Controller;

import Model.CommandHandler.Commands.Pair;
import Model.EntryBlock;
import View.Handler;

public class Executor implements IExecutor{
    final private EntryBlock model = new EntryBlock();
    final private Handler view = new Handler();
    @Override
    public void execute() {
        Pair<Integer, String> response = model.start();
        String request;
        do {
            request = view.update(response.getRight());
            response = model.execute(request);
        } while (response.getLeft() != -1);
        view.send(response.getRight());
        System.exit(0);
    }
}
