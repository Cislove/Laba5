package Model;

import Model.CommandHandler.Commands.Pair;

public interface IModel {
    public Pair<Integer, String> execute(String request);
    public Pair<Integer, String> start();
}

