package View;

public class Handler {
    private final Receiver rec = new Receiver();
    private final Responder res = new Responder();
    public String update(String str){
        rec.print(str);
        return res.consoleIn();
    }
    public void send(String str){
        rec.print(str);
    }
}
