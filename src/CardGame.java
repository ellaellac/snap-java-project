import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CardGame {
    public String name;
    private String suit;
    private String symbol;
    private int value;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> deckOfCards = new ArrayList<>();
    private String[] suits = {"♣", "♦", "♥", "♠"};
    private String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    static int cardIndex;

    // constructor
    public CardGame(String name) {
        this.name = name;
        for (int i = 0; i < symbols.length; i++) {
            symbol = symbols[i];
            value = values[i];
            for (int u = 0; u < suits.length; u++) {
                suit = suits[u];
                cards.add(new Card(suit, symbol, value));
            }
        }
    }

    //Getter and Setter

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(ArrayList<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public String[] getSuits() {
        return suits;
    }

    public void setSuits(String[] suits) {
        this.suits = suits;
    }

    public String[] getSymbols() {
        return symbols;
    }

    public void setSymbols(String[] symbols) {
        this.symbols = symbols;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public static int getCardIndex() {
        return cardIndex;
    }

    public static void setCardIndex(int cardIndex) {
        CardGame.cardIndex = cardIndex;
    }

    //comparator
    class ValueComparator implements Comparator<Card> {
        public int compare(Card card1, Card card2) {
            if (card1.value == card2.value) {
                return 0;
            } else if (card1.value > card2.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    class SuitComparator implements Comparator<Card> {
        public int compare(Card card1, Card card2) {
            return card1.suit.compareTo(card2.suit);
        }
    }

    //methods
    public ArrayList<Card> getDeck() {
        return cards;
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(cards, new ValueComparator());
        return cards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        Collections.sort(cards, new SuitComparator());
        return cards;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(cards, new Random());
        return deckOfCards = cards;
    }

    public void dealCard() {
        Card card = deckOfCards.get(cardIndex++);

        if (cardIndex == 52) {
            setCardIndex(0);
            shuffleDeck();
        }

        System.out.println(card);
    }
}
