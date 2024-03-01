package Model.CommandHandler.Commands;

import Model.Storage.IStorage;
import Model.Storage.ObjectDescription.baseMetaData;

public class InfoCommand implements Command{
    IStorage storage;
    public String execute(){
        baseMetaData data = storage.getmData();
        String s = "Информация о коллекции:" + "\n";
        s += "Дата инициализации - " + data.initDate + "\n";
        s += "Тип коллекции - " + data.typeCollection + "\n";
        s += "Размер коллекции - " + data.size;
        return s;
    }
}