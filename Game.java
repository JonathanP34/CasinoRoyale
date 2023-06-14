import java.util.*;
public class Game {
    private boolean playing;
    private boolean running;
    private Stack<State> stateStack;
    private String userInput;

    //Constructor
    public Game() {
        //Initializing the game
        playing = false;
        running = true;
        stateStack = new Stack<State>();
        userInput = null;
        loadStates(); //Method to set the title state to the stack
    }


    //Methods of consequence

    public void loadStates() {
        Title titleState = new Title();
        stateStack.push(titleState);
    }



    //Setters and Getters
    public boolean getPlaying() {
        return playing;
    }
    public boolean getRunning() {
        return running;
    }
    public Stack<State> getStateStack() {
        return stateStack;
    }

    public void setPlaying(boolean newPlaying) {
        playing = newPlaying;
    }
    public void setRunning(boolean newRunning) {
        running = newRunning;
    }
    public void setStateStack(Stack<State> newStack) {
        stateStack = newStack;
    }
}
