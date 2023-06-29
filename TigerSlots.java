import java.util.*;
public class TigerSlots extends State {
    private double spinAmount;
    public TigerSlots(Game g, Player p) {
        super(g, p);
        spinAmount = 0.2;
    }

    public void render() {
        scroll();
        if (getGame().getPlaying() == false) {
            System.out.println("*****************************");
            System.out.println("*        TIGER SLOTS        *");
            System.out.println("*****************************\n");
        } else {
            System.out.println("-----TIGER SLOTS-----\n");
            System.out.println("Current Balance: $" + getPlayer().getBalance());
            System.out.println("Amnt/spin: $" + spinAmount);
            System.out.println("1) Roll");
            System.out.println("2) Add Balance");
            System.out.println("3) Change Spin Amount");
            System.out.println("4) Exit Game");
        }
    }

    public void update() {
        Scanner userInput = new Scanner(System.in);
        boolean done = false;
        int choice = 0;
        if (getGame().getPlaying() == false) {
            String text = userInput.nextLine();
            if (text.length() > 0) {
                getGame().setPlaying(true); //Setting playing to true
            }
        } else {
            while (done == false) {
                try {
                    String text = userInput.nextLine();
                    choice = Integer.parseInt(text);

                    if (choice > 0 && choice < 5) {
                        done = true;
                    } else {
                        System.out.println("ERROR 6 - ENTER VALID VALUE");
                    }
                } catch(Exception e) {
                    System.out.println("ERROR 5 - ENTER PROPER VALUE");
                }
            }

            switch(choice) {
                case 1:
                    roll();
                    System.out.println("Rolled!");
                    break;
                case 2:
                    System.out.println("\n"); //Adding space before the balance
                    getPlayer().addBalance();
                    break;
                case 3:
                    System.out.println("\n"); //Adding space before the balance
                    System.out.print("New Balance: ");
                    double newSpinAmount = userInput.nextDouble();
                    setSpinAmount(newSpinAmount);
                    break;
                case 4:
                    exitState();
                    break;
            }

        }
    }

    private void roll() {
        Random rand = new Random();
        int[] randInts = new int[3];
        double value = 0;

        //Getting the random object for each slot
        for (int i = 0; i < 3; i++) {
            randInts[i] = rand.nextInt(3);
        }
        getPlayer().loseMoney(spinAmount);
        displaySpin(randInts);
        value = calculateReturn(randInts);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

    private void displaySpin(int[] randInts) {
        String[] objects = {"Lemon", "Melon", "Seven", "Charm"};
        System.out.println("--------------------------");
        System.out.println("| " + objects[randInts[0]] + " - " + objects[randInts[1]] + " - " + objects[randInts[2]] + " |");
        System.out.println("--------------------------");
    }

    private double calculateReturn(int[] randInts) {
        double value = 0;
        if (randInts[0] == randInts[1]) {
            if (randInts[1] == randInts[2]) {
                //Since there are 4 objects and you need all 3 then its 1/64 chance each to get a jackpot then
                //you will probably roll 4/64=1/16 times costing spinAmounnt * 16 then the return is ~94% or 15
                value = 15 * spinAmount;
                System.out.println("YOU WON $" + value + "!!!!!!");
            }
        }
        getPlayer().addWinnings(value);
        return value;
    }

    //Setters and Getters
    public double getSpinAmount() {
        return spinAmount;
    }
    public void setSpinAmount(double newSpinAmount) {
        spinAmount = newSpinAmount;
    }

}
