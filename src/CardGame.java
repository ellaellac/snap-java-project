import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CardGame {
    public String name;
    public String suit;
    public String symbol;
    public int value;
    public ArrayList<Card> cards = new ArrayList<>();
    public ArrayList<Card> deckOfCards = new ArrayList<>();
    public String[] suits = {"♣", "♦", "♥", "♠"};
    public String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
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

    //comparator
    class ValueComparator implements Comparator<Card> {
        public int compare(Card card1, Card card2){
            if(card1.value == card2.value){
                return 0;
            }else if (card1.value > card2.value){
                return 1;
            }else{
                return -1;
            }
        }
    }

    class SuitComparator implements Comparator<Card> {
        public int compare(Card card1, Card card2){
            return card1.suit.compareTo(card2.suit);
        }
    }

    //methods
    public ArrayList<Card> getDeck() {
        return cards;
    }

    public ArrayList<Card> sortDeckInNumberOrder(){
        Collections.sort(cards, new ValueComparator());
        return cards;
    }

    public ArrayList<Card> sortDeckIntoSuits(){
        Collections.sort(cards, new SuitComparator());
        return cards;
    }

    public ArrayList<Card> shuffleDeck(){
        Collections.shuffle(cards, new Random());
        return deckOfCards = cards;
    }

    public Card dealCard() {
        return deckOfCards.get(cardIndex++);
    }




}
