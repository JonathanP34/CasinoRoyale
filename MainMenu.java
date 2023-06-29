import java.util.*;
public class MainMenu extends State {
    public MainMenu(Game g, Player p) {
        super(g, p);
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
        int choice = 0;
        boolean done = false;
        //For loop to make sure you get the proper

        while (done == false) {
            try {
                String val = userInput.nextLine();
                choice = Integer.parseInt(val);

                if (choice > 0 && choice < 5) {
                    done = true;
                } else {
                    System.out.println("Error 3");
                    System.out.println("Please enter a valid value corresponding to the menu options above.");
                }
            } catch (Exception e) {
                System.out.println("Error 2");
                System.out.println("Please enter valid integer value.");
            }
        }

        switch(choice) {
            case 1:
                ChooseGame cg = new ChooseGame(getGame(), getPlayer()); // <- Problem here
                cg.enterState(); //Entering the Choose Game State
                //System.out.println(getGame().getStateStack().peek().toString());
                break;
            case 2:
                System.out.println("\n"); //Adding space before the balance
                getPlayer().addBalance();
                break;
            case 3:
                //Stat State <- Saving this for later because I want to choose the stats from each game in specific, poker =/= slots
                break;
            case 4:
                exitState(); //Exiting the menu state
                break;
        }

    }

    public String toString() {
        return "Main Menu State";
    }

}
