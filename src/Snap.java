import java.util.*;

public class Snap extends CardGame {

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
    @Override
    public void dealCard() {
        System.out.println("Please press Enter to play.");
        while (true) {
            Card card = getDeckOfCards().get(cardIndex);
            System.out.println("");
//            System.out.println("CardIndex " + cardIndex);

            if (cardIndex % 2 != 0) {
                System.out.println("Computer");
                Player.computerMove();
            } else {
                System.out.println("Your turn");
                Player.playerMove();
            }

            if (!Player.getInput().equals("")) {
                dealCard();
            } else if (cardIndex % 2 != 0 && snapCards.stream().anyMatch(element -> element.symbol.equals(card.symbol))) {
                System.out.println(card);
                System.out.println("You lose");
                break;
            } else if (cardIndex % 2 == 0 && snapCards.stream().anyMatch(element -> element.symbol.equals(card.symbol))) {
                System.out.println(card);
                System.out.println("You win");
                break;
            } else if (cardIndex == 52) {
                setCardIndex(0);
                shuffleDeck();
            }

            snapCards.add(getDeckOfCards().get(cardIndex++));
            System.out.println(card);
//            System.out.println(snapCards);
        }
    }


}





