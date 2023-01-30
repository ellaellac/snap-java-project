import java.util.Scanner;

public class Player {
    static Scanner scanner = new Scanner(System.in);

    static String input;


    public static String getInput() {
        return input;
    }

    public static void setInput(String input) {
        Player.input = input;
    }


    static void playerMove() {
        input = scanner.nextLine();
        System.out.println("Your turn");
    }

    static void computerMove() {
        input = scanner.nextLine();
        System.out.println("Computer");
    }

}
