import java.util.*;
public class MainMenu extends State {
    private int userChoice;

    public MainMenu() {
        super();
        userChoice = 0;
    }

    public void render() { //Displaying the options in the menu
        scroll();
        System.out.println("-----MAIN MENU-----\n");
        System.out.println("1) Choose a game");
        System.out.println("2) Add Balance");
        System.out.println("3) Check Stats");
        System.out.println("4) Exit Game");
    }

    public void update() {
        Scanner userInput = new Scanner(System.in);
        String val = userInput.nextLine();
        int choice;
        boolean done = false;
        while (done == false) {
            try {
                choice = Integer.parseInt(val);

                if (choice > 0 && choice < 5) {
                    switch(choice) {
                        case 1:
                            break; //Choose game state
                        case 2:
                            break; //Balance State
                        case 3:
                            break; //Stat State
                        case 4:
                            System.exit(0);
                            break;
                    }
                } else {
                    System.out.println("Error 3");
                    System.out.println("Please enter a valid value corresponding to the menu options above.");
                }
            } catch (Exception e) {
                System.out.println("Error 2");
                System.out.println("Please enter valid integer value.");
            }
        }

    }


}
