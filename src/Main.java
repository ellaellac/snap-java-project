public class Main {
    public static void main(String[] args) {
        CardGame cardGame = new CardGame("Snap");
        System.out.println(cardGame.cards);
        cardGame.shuffleDeck();
        System.out.println(cardGame.deckOfCards);
        System.out.println(cardGame.dealCard());
        System.out.println(cardGame.dealCard());
        System.out.println(cardGame.dealCard());
    }

}