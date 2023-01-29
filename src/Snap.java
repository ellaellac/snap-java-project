import java.util.*;

public class Snap extends CardGame {
    Scanner scanner = new Scanner(System.in);

    public ArrayList<Card> snapCards = new ArrayList<>();

    //Constructor
    public Snap(String name) {
        super(name);
    }

    //Getter and Setter


    public ArrayList<Card> getSnapCards() {
        return snapCards;
    }

    public void setSnapCards(ArrayList<Card> snapCards) {
        this.snapCards = snapCards;
    }

    //Method
    public void runSnap() {
        shuffleDeck();
        System.out.println(shuffleDeck());
        while (true) {
            Card card = getDeckOfCards().get(cardIndex++);
            System.out.println("Please press Enter to play.");
            String enter = scanner.nextLine();
            if (!enter.equals("")) {
                runSnap();
            } else if (snapCards.stream().anyMatch(element -> element.symbol.equals(card.symbol))) {
                System.out.println(card);
                System.out.println("Win");
                break;
            }
            snapCards.add(card);
            System.out.println(card);
            System.out.println(snapCards);
        }
    }
}





