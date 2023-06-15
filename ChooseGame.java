import java.util.Scanner;

public class ChooseGame extends State {
    public ChooseGame() {
        super();
    }

    public void render() {
        scroll();
        System.out.println("-----CHOOSE GAME-----\n");
        System.out.println("1) Slots");
        System.out.println("2) Blackjack");
        System.out.println("3) Crash");
        System.out.println("4) Back to Menu");
    }

    public void update() {
        Scanner userInput = new Scanner(System.in);
        int choice;
        while (true) { //Goes until it breaks
            try {
                String val = userInput.nextLine();
                choice = Integer.parseInt(val);

                if (choice > 0 && choice < 3) { //5 is the number of games
                    switch (choice) {
                        case 1:
                            //Play the slots
                            break;
                        case 2:
                            //Play blackjack state
                            break;
                        case 3:
                            //To crash
                            break;
                        case 4:
                            //Returning to the menu
                            this.exitState();
                            break;
                    }
                } else {
                    System.out.println("Value Error - Enter valid integer");
                }
            } catch (Exception e) {
                System.out.println("Type Error - Enter integer");
            }
        }
    }
}
