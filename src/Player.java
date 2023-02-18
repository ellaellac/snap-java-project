import java.util.Scanner;

public class Player {
    private static Scanner scanner = new Scanner(System.in);

    private static String input;

    //Getter and Setter
    public static String getInput() {
        return input;
    }

    public static void setInput(String input) {
        Player.input = input;
    }

    //Methods
    public static void playerMove() {
        input = scanner.nextLine();
        System.out.println("Your turn");
    }

    public static void computerMove() {
        input = scanner.nextLine();
        System.out.println("Computer");
    }

}
