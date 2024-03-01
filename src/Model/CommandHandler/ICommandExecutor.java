package Model.CommandHandler;

import Model.Storage.StorageObject.StudyGroup;

public interface ICommandExecutor {
    public String help();
    public String info();
    public String show();
    public String addElement(StudyGroup el);
    public String updateElementById(int id, StudyGroup el);
    public String
}
