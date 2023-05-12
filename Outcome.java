import java.util.*;
import java.util.ArrayList;
public class Outcome {
    private static int[] value = {
            1 , 2 , 3 , 4 ,
            5 , 6 , 7 , 8 ,
            9 , 10 , 11 , 12
    };
    private int die1;
    private int die2;
    private int dieTotal = 0;

    private ArrayList<String> nums = new ArrayList<String>();

    public void setNums(int die1, int die2, int total) {
        String die1String = Integer.toString(die1);
        String die2String = Integer.toString(die2);
        String totalString = Integer.toString(total);

        nums.add(die1String);
        nums.add(die2String);
        nums.add(totalString);
    }

    public boolean endGame() {
        boolean isEnd;
        if (!isValid(die1) && !isValid(die2) && !isValid(dieTotal)) {
            isEnd = true;
        } else isEnd = false;
        return isEnd;
    }

    public static int[] getValue() {
        return value;
    }

    private int findIndex(int[] arr, int t) {
        int len = arr.length;
        //System.out.println(len);
        int pos = 0;
        int output = -1;

        while (pos < len) {
            if (arr[pos] == t) {
                output = arr[pos];
                //System.out.println(output);
                break;
            }
            pos++;
        }
        return output;
    }

    public boolean isValid(int a) {
        return findIndex(value, a) != -1;
    }

    public int[] removeInt(int[] arr, int val) {
        int[] newArray = new int[arr.length - 1];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                continue;
            }

            newArray[j++] = arr[i];

        }
        return newArray;
    }


    public Outcome(int a, int b) {
        die1 = a;
        die2 = b;
    }

    public int getTotal() {
        dieTotal = die1 + die2;
        return die1 + die2;
    }

    public void removeValue(int a, int b) {
        boolean flag;
        if (a + b == dieTotal) {
            int toRemove = findIndex(value, a);
            value = removeInt(value, toRemove);
            toRemove = findIndex(value, b);
            value = removeInt(value, toRemove);
        } else System.out.println("Error.");

    }

    public void removeValue(int c) {

        if (c == dieTotal) {
            int toRemove = findIndex(value, dieTotal);
            value = removeInt(value, toRemove);
        } else if (c == die1 || c == die2) {
            int toRemove = findIndex(value, c);
            value = removeInt(value, toRemove);
        } else System.out.println("Error");

    }


}
