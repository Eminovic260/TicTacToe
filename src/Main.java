import controller.*;

public class Main {
    public static void main(String[] args) {
        StatusMachine statusMachine = new StatusMachine();
        while (true) {
            statusMachine.update();
        }
    }
}
