public class NumberGuess {
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
            round++;

            int[] range = askNumber(round, minimum, maximum);
            minimum = range[0];
            maximum = range[1];
        }

        System.out.println("Number solved! It was: " + minimum);
    }

    public static int[] askNumber(int round, int minimum, int maximum) {
        int number = (minimum + maximum) / 2;

        int[] output = new int[2];
        output[0] = minimum;
        output[1] = maximum;

        boolean answer = askQuestion("\nRound " + round + ": Is the number greater than " + number + "?");

        if (answer) {
            output[0] = number + 1;
        } else {
            output[1] = number;
        }
        
        return output;
    }

    public static boolean askQuestion(String question) {
        // Show question to user
        System.out.println(question);

        // Read user's answer and convert it to lower case
        String input = System.console().readLine("Please type either Y[es] or N[o] to continue: ").toLowerCase();

        // Deal with the user input
        if(input.equals("y")){
            return true;
        }else if(input.equals("n")){
            return false;
        }else{
            System.out.println("\nIncorrect answer. Please try again.\n");
            return askQuestion(question);
        }
    }
}
