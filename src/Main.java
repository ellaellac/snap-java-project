public class Main {
    public static void main(String[] args) {
        CardGame cardGame = new CardGame("Snap");
        System.out.println(cardGame.getDeck());
        System.out.println(cardGame.sortDeckInNumberOrder());
        System.out.println(cardGame.sortDeckIntoSuits());
    }



}