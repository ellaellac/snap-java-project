import java.util.Scanner;

public class Player {
    static Scanner scanner = new Scanner(System.in);

    static String input;

    static String snapInput;

    public static String getInput() {
        return input;
    }

    public static void setInput(String input) {
        Player.input = input;
    }

    public static String getSnapInput() {
        return snapInput;
    }

    public static void setSnapInput(String snapInput) {
        Player.snapInput = snapInput;
    }

    static void playerMove() {
        input = scanner.nextLine();
    }

    static void computerMove() {
        input = "";
    }


}
