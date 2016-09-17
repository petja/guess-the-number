package NumberGuess;

import java.util.ArrayList;
import NumberGuess.GameCommon;

public class AnotherApproach {

    // Initialize variables
    private int minimum = 1;
    private int maximum = 999;
    private int round = 0;
    private ArrayList<Integer> possibilities;

    public static void main(String[] args) {
        AnotherApproach game = new AnotherApproach();
        game.startGame();
    }

    public void startGame() {
        // Create an array of the numbers between the minimum and the maximum
        this.possibilities = GameCommon.rangeArray(this.minimum, this.maximum);

        // Intro
        System.out.println("\n\u001B[01mPlease think any number between " + minimum + " and " + maximum + "\u001B[00m");
        System.console().readLine("Press [ENTER] to start the game\n");

        // Ask if the number is divisible with 10
        boolean divide10 = askDivisibility(10);

        // Run the game until we have the result
        while(possibilities.size() > 1) {
            askNumber();
        }

        // Game finished
        System.out.println("\n\u001B[01m\u001B[32mNumber resolved!\u001B[00m");
        System.out.println("The number was " + possibilities.get(0) + ", wasn't it?\n");
    }

    public boolean askDivisibility(int divider) {
        // Increase the round
        round++;

        boolean answer = GameCommon.askQuestion("\n\u001B[01mRound " + round + ": Is the number divisible with \u001B[30m\u001B[47m" + divider + "\u001B[39m\u001B[49m?\u001B[00m");

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

        possibilities = newPossibilities;

        return answer;
    }

    public void askNumber() {
        // Increase round
        round++;

        // Tell user how many possibilities there are left
        System.out.println("\nGot it. " + possibilities.size() + " possible numbers left. Let's continue.");

        // Find minimum and maximum value from the array
        int minimum = possibilities.get(0);
        int maximum = possibilities.get(possibilities.size() - 1);

        // Find the average value between minimum and maximum values
        int average = (minimum + maximum) / 2;

        // Ask question from the user
        boolean answer = GameCommon.askQuestion("\n\u001B[01mRound " + round + ": Is the number greater than \u001B[30m\u001B[47m" + average + "\u001B[39m\u001B[49m?\u001B[00m");

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

        possibilities = newPossibilities;
    }
}
