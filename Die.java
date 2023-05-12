import java.util.Scanner;
import java.util.*;
public class Die {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private int dieValue;


    public int roll() {
        dieValue = random.nextInt(6) + 1;
        return dieValue;
    }

    public int userEnter() {
        String input = "none";
        do {
            System.out.println("Press enter to roll the die.");
            input = scanner.nextLine();
        } while (!input.equals(""));
        return this.roll();
    }
}
