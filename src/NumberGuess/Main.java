package NumberGuess;

import NumberGuess.GameCommon;

public class Main {
    public static void main(String[] args) {
        int minimum = 1;
        int maximum = 1000;

        // boolean answer = askQuestion("Is the number divisible with two?");
        // System.out.println(answer);

        // Intro
        System.out.println("\nPlease think any number between " + minimum + " and " + maximum);
        System.console().readLine("Press [ENTER] when you're ready to go!\n");

        // Keep count on rounds
        int round = 0;

        while(minimum != maximum) {
            // Next round!
            round++;

            int[] range = askNumber(round, minimum, maximum);
            minimum = range[0];
            maximum = range[1];
        }

        System.out.println("\nNumber solved! It was: " + minimum + "\n");
    }

    public static int[] askNumber(int round, int minimum, int maximum) {
        // Find the average value between minimum and maximum values
        int number = (minimum + maximum) / 2;

        // Throw minimum and maximum values to integer array
        int[] output = new int[2];
        output[0] = minimum;
        output[1] = maximum;

        // Ask question from the user
        boolean answer = GameCommon.askQuestion("\nRound " + round + ": Is the number greater than " + number + "?");

        if (answer) {
            // If N is greater than average, set new minimum value
            output[0] = number + 1;
        } else {
            // If N is equal or less than average, set new maximum value
            output[1] = number;
        }
        
        return output;
    }
}
