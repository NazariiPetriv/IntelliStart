package main.java;
import java.util.*;

import java.util.*;

public class HarekCity {
    public String[] createEmptyNameArray() {
        String[] result = new String[0];
        return result;
    }

    public int[] createAgeArray(int age1, int age2, int age3, int age4) {
        return new int[] {age1, age2, age3, age4};
    }

    public void fixNames(String[] names, String[] toReplace) {
        names[1] = toReplace[0];
        names[3] = toReplace[1];
    }

    public String firstAndLastTogether(String[] names) {
        return names[0] + " AND " + names[9] + " TOGETHER";
    }

    public void changeElectResult(String[] results) {
        String temp = results[0];
        results[0] = results[results.length - 1];
        results[results.length - 1] = temp;
    }

    public String[] changeElectResultAgain(String[] results) {
        return new String[] {
                results[2],
                results[3],
                results[4]
        };
    }

    public char[][] createKeyboard() {
        return new char[][]  {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}
        };
    }

    public void printKeyboard(){
        char[][] keyboard = new HarekCity().createKeyboard();
        System.out.println(Arrays.toString(keyboard[0]));
        System.out.println(Arrays.toString(keyboard[1]));
        System.out.println(Arrays.toString(keyboard[2]));
        System.out.println(Arrays.toString(keyboard[3]));


    }

    public static void main(String[] args) {
        new HarekCity().printKeyboard();
    }
}
