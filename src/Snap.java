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
            System.exit(0);
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
    public void checkUserInputInTwoSeconds(){
        timer.schedule(checkUserInput, 2000);
        String userInput = scanner.nextLine().toLowerCase();
        setUserInput(userInput);
    }


    @Override
    public void dealCard() {
        System.out.println("Please press Enter to play SNAP.");
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
                checkUserInputInTwoSeconds();
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





