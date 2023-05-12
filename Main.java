import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        // Initial comments.
        System.out.println("Welcome to Shut the Box.\nTo play, you will roll two six sided die. You can then choose to flip either two additive factors of the total (ex. 2 + 3 = 5),\nor flip over the number corresponding to the sum of the two dice.\nYou lose when you can no longer flip a remaining number.\nFlip all numbers to successfully shut the box!");


        boolean endLoop = false;
        while (!endLoop) {


            Scanner scanner = new Scanner(System.in);
            Die die1 = new Die();
            Die die2 = new Die();

            String input = "none";
            do {
                System.out.println("Press enter to roll the die.");
                input = scanner.nextLine();
            } while (!input.equals(""));

            int die1Roll = die1.roll();
            int die2Roll = die2.roll();

            System.out.println("Die 1: " + die1Roll);
            System.out.println("Die 2: " + die2Roll);

            Outcome game = new Outcome(die1Roll, die2Roll);
            int dieTotal = game.getTotal();

            System.out.println("Total: " + dieTotal);

            endLoop = game.endGame();
            if (endLoop) {
                break;
            }

            game.setNums(die1Roll, die2Roll, dieTotal);
            ArrayList<String> valuesLeft = new ArrayList<String>();
            int[] valuesInt = Outcome.getValue();


            for (int i = 0; i < valuesInt.length; i++) {
                valuesLeft.add(Integer.toString(valuesInt[i]));
            }

            //System.out.println(valuesLeft);

            ArrayList<String> inNums = new ArrayList<>();
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Enter the numbers from the list that you'd like to remove. (ex. 3,5)\n" + valuesLeft);
                String userInput = scanner.nextLine();

                StringTokenizer str = new StringTokenizer(userInput, ", ");

                while (str.hasMoreTokens()) {
                    inNums.add(str.nextToken());
                }

                //System.out.println(inNums.size());
                //
                //System.out.println(inNums.get(0));


                int[] numsInt = new int[inNums.size()];
                for (int i = 0; i < inNums.size(); i++) {
                    numsInt[i] = Integer.parseInt(inNums.get(i));
                }

                if (inNums.size() == 2) {
                    for (int i = 0; i < inNums.size(); i++) {
                        if (numsInt[i] == die1Roll || numsInt[i] == die2Roll) {
                            validInput = true;
                        } else {
                            validInput = false;
                            System.out.println("Invalid.");
                            break;
                        }

                    }
                } else if (inNums.size() == 1) {
                    if (numsInt[0] == dieTotal || numsInt[0] == die1Roll || numsInt[0] == die2Roll) {
                        validInput = true;
                    }
                } else System.out.println("Invalid");
            }

            if (inNums.size() == 2) {
                game.removeValue(Integer.parseInt(inNums.get(0)), Integer.parseInt(inNums.get(1)));
            } else {
                game.removeValue(Integer.parseInt(inNums.get(0)));
            }

            System.out.println("Numbers removed! Roll again.");



        }

    }


}

