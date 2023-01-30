import java.util.*;

public class Snap extends CardGame {
    public Scanner scanner = new Scanner(System.in);
    public ArrayList<Card> snapCards = new ArrayList<>();

    private String userInput = "";

    Timer timer = new Timer();

    TimerTask checkUserInput = new TimerTask() {
        @Override
        public void run() {
            if (userInput.equals("snap")) {
                System.out.println("You win. Play Again.");
            } else {
                System.out.println("You lost. Play Again.");
            }
        }
    };

    //Constructor
    public Snap(String name) {
        super(name);
    }

    //

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    //Method
    public void userInput() {
        String userInput = scanner.nextLine().toLowerCase();
        setUserInput(userInput);
    }

    public void checkUserInputInTwoSeconds(){
        timer.schedule(checkUserInput, 2000);
    }


    @Override
    public void dealCard() {
        System.out.println("Please press Enter to play.");
        while (true) {
            Card card = getDeckOfCards().get(cardIndex);
            System.out.println("");

            if (cardIndex % 2 != 0) {
                Player.computerMove();
            } else {
                Player.playerMove();
            }

            if (!Player.getInput().equals("")) {
                dealCard();
            } else if (snapCards.stream().anyMatch(element -> element.symbol.equals(card.symbol))) {
                System.out.println(card);
                System.out.println("hello");
                checkUserInputInTwoSeconds();
                userInput();
                break;
            } else if (cardIndex == 52) {
                setCardIndex(0);
                shuffleDeck();
            }
            snapCards.add(getDeckOfCards().get(cardIndex++));
            System.out.println(card);
        }
    }

    public void runSnap() {
        shuffleDeck();
        dealCard();
    }


}





