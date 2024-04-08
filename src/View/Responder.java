package View;

import java.util.Scanner;

public class Responder implements sendable{
    private final Scanner scn = new Scanner(System.in);
    @Override
    public String consoleIn() {
        return scn.nextLine();
    }
}
