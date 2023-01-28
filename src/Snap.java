import java.util.*;

public class Snap extends CardGame {
    Scanner scanner = new Scanner(System.in);

    public Snap(String name) {
        super(name);
    }

    //Method
    @Override
    public Card dealCard() {
        System.out.println("Please press Enter to start and take turn.");
        String enter = scanner.nextLine();

        if (!enter.equals("")) {
            dealCard();
        } else if (enter.equals("") && cardIndex == 52) {
            setCardIndex(0);
            shuffleDeck();
        }
        return deckOfCards.get(cardIndex++);
    }


}
