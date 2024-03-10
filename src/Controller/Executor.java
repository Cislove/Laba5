package Controller;

import Model.EntryBlock;
import View.Handler;

public class Executor implements IExecutor{
    final private EntryBlock model = new EntryBlock();
    final private Handler view = new Handler();
    @Override
    public void execute() {
        String response = model.start();
        String request;
        do {
            request = view.update(response);
            response = model.execute(request);
        } while (response != null);
        System.out.println("Программа завершила работу");
        System.exit(0);
    }
}
