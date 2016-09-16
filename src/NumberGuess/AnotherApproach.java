package NumberGuess;

import java.util.ArrayList;
import NumberGuess.GameCommon;

public class AnotherApproach {
    public static void main(String[] args) {
        int minimum = 1;
        int maximum = 1000;

        // Create array of numbers between minimum and maximum
        ArrayList<Integer> possibilities = GameCommon.rangeArray(minimum, maximum);

        // Intro
        System.out.println("\nPlease think any number between " + minimum + " and " + maximum);
        System.console().readLine("Press [ENTER] when you're ready to go!\n");

        // Keep count on rounds
        int round = 0;

        round++;
        possibilities = askDivisibility(round, possibilities, 2);

        round++;
        possibilities = askDivisibility(round, possibilities, 5);

        while(possibilities.size() > 1) {
            // Next round!
            round++;

            ArrayList<Integer> range = askNumber(round, possibilities);
            possibilities = range;
        }

        System.out.println("\n\u001B[01m\u001B[32mGot it!\u001B[00m\nThe number was " + possibilities.get(0) + ", wasn't it?\n");
    }

    public static ArrayList<Integer> askDivisibility(int round, ArrayList<Integer> possibilities, int divider) {
        boolean answer = GameCommon.askQuestion("\n\u001B[01mRound " + round + ": Is the number divisible with " + divider + "?\u001B[00m");

        ArrayList<Integer> newPossibilities = new ArrayList<Integer>();

        if (answer) {
            // Number is divisible
            for(int number : possibilities){
                if(number % divider == 0) {
                    newPossibilities.add(number);
                }
            } 
        } else {
            // Number is not divisible
            for(int number : possibilities){
                if(number % divider != 0) {
                    newPossibilities.add(number);
                }
            } 
        }

        return newPossibilities;
    }

    public static ArrayList<Integer> askNumber(int round, ArrayList<Integer> possibilities) {
        // Tell user how many possibilities there are left
        System.out.println("\nGot it. " + possibilities.size() + " possible numbers left. Let's continue.");

        // Find minimum and maximum value from the array
        int minimum = possibilities.get(0);
        int maximum = possibilities.get(possibilities.size() - 1);

        // Find the average value between minimum and maximum values
        int average = (minimum + maximum) / 2;

        // Ask question from the user
        boolean answer = GameCommon.askQuestion("\n\u001B[01mRound " + round + ": Is the number greater than " + average + "?\u001B[00m");

        ArrayList<Integer> newPossibilities = new ArrayList<Integer>();

        if (answer) {
            // If N is greater than average, set new minimum value
            for(int number : possibilities){
                if(number > average) {
                    newPossibilities.add(number);
                }
            } 
        } else {
            for(int number : possibilities){
                if(number <= average) {
                    newPossibilities.add(number);
                }
            } 
        }
        
        return newPossibilities;
    }
}
