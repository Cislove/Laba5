package Model.Validation.ClosedFieldHandler.IDhandler;

import java.util.LinkedList;

public class IDHandler {
    private LinkedList <Integer> freeId;
    private int countBusyId;
    public IDHandler(){
        freeId = new LinkedList<>();
        for(int i = 1; i <= 100; i++){
            freeId.add(i);
        }
    }
    public boolean checkId(int id){
        if(countBusyId + freeId.size() < id){
            return false;
        }
        return !freeId.contains(id);
    }

    private void expandListId(){
        for(int i = countBusyId + 1; i <= countBusyId * 2; i++){
            freeId.add(i);
        }
    }
    public void setId(int id) throws IDException{
        //System.out.println(freeId);
        while(id >= (countBusyId + freeId.size())){
            expandListId();
        }
        if(checkId(id)){
            throw new IDException();
        }
        //Integer newId = id;
        freeId.remove((Integer) id);
    }
    private Integer closeId(){
        countBusyId++;
        return freeId.remove(0);
    }
    public Integer getFreeId(){
        if(freeId.isEmpty()){
           expandListId();
        }
        return closeId();
    }
}
