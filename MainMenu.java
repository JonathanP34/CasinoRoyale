import java.util.*;
public class MainMenu extends State {
    public MainMenu() {
        super();
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
        int choice;
        boolean done = false;
        //For loop to make sure you get the proper
        while (done == false) {
            try {
                String val = userInput.nextLine();
                choice = Integer.parseInt(val);

                if (choice > 0 && choice < 5) {
                    switch(choice) {
                        case 1:
                            ChooseGame cg = new ChooseGame();
                            cg.enterState();
                            break;
                        case 2:
                            getPlayer().addBalance();
                            break;
                        case 3:
                            //Stat State <- Saving this for later because I want to choose the stats from each game in specific, poker =/= slots
                            break;
                        case 4:
                            exitState();
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
