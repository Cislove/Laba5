package Model.IStore;

import Model.Storage.IStorage;
import Model.Storage.Storage;

public class IStore implements IModel{
    private Storage inst;
    public IStore(){
        inst = new Storage();
    }

    public Storage getEllStorage(){
        return inst;
    }
}
