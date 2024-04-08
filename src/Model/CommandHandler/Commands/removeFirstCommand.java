package Model.CommandHandler.Commands;

import Model.Storage.IStorage;

/**
 * Класс реализации команды "remove_first"
 * @author Ильнар Рахимов
 */
public class removeFirstCommand implements Command{
    IStorage storage;
    public removeFirstCommand(IStorage storage){
        this.storage = storage;
    }
    @Override
    public Pair<Integer, String> execute(){
        storage.delElement(0);
        return new Pair<>(0, "Первый элемент успешно удален!\n");
    }
}
