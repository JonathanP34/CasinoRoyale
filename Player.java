import java.util.*;
public class Player {
    private int balance;
    private int winnings;

    //Constructor
    public Player() {
        balance = 0;
        winnings = 0;
    }

    public void addBalance() {
        Scanner userInput = new Scanner(System.in);
        int newBal = 0;
        String input = "";
        while (true) {
            try {
                input = userInput.nextLine();
                newBal = Integer.parseInt(input);

                balance += newBal;
                break;
            } catch (Exception e) {
                System.out.println("Error 4 - Invalid value");
            }
        }

    }

    public void addWinnings(int add) {
        winnings += add;
        balance += add;
    }

    public void loseMoney(int loss) {
        balance -= loss;
        winnings -= loss;
    }


    //Getters and Setters
    public int getBalance() {
        return balance;
    }
    public int getWinnings() {
        return winnings;
    }

    public void setBalance(int newBalance) {
        balance = newBalance;
    }
    public void setWinnings(int newWinnings) {
        winnings = newWinnings;
    }

}
