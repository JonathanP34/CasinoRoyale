import java.util.*;
public class Title extends State{
    public Title() {
        super();
    }
    public void update() {
        //Getting the user input, if they type anything the game begins
        Scanner userInput = new Scanner(System.in);
        System.out.println("Type anything to continue: ");
        String text = userInput.nextLine();
        if (text.length() > 0) {
            MainMenu menuState = new MainMenu();
            menuState.enterState(); //Entering the menuState
        }
    }

    public void render() {
        scroll();
        System.out.println("*****************************");
        System.out.println("*       CASINO ROYALE       *");
        System.out.println("*****************************\n");
    }
}
