import java.util.*;
public class State {
    private Game game;
    private State prevState;

    //Constructor
    public State() {
        game = new Game();
        prevState = null;
    }

    public void update() {
    }
    public void render() {
    }
    public void enterState() {
        if (game.getStateStack().size() > 1) {
            prevState = game.getStateStack().peek();
        }
        game.getStateStack().push(this); //Pushing its own state on the stack
    }

    public void exitState() {
        game.getStateStack().pop();
        if (game.getStateStack().size() > 1) { //If there is more than one state
            State temp = game.getStateStack().pop(); //Pop off, get the previous state then push back on
            prevState = game.getStateStack().peek();
            game.getStateStack().push(temp);
        } else { //If there is only 1 state left
            prevState = null;
        }
    }

    public void scroll() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("\n");
                Thread.sleep(30);
            }
        } catch (Exception e) {
            System.out.println("Error Code 1");
        }
    }

    //Setters and Getters
    public State getPrevState() {
        return prevState;
    }
    public void setPrevState(State newPrevState) {
        prevState = newPrevState;
    }
}
