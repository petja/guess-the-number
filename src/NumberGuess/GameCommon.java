package NumberGuess;

import java.util.ArrayList;

public class GameCommon {
    public static boolean askQuestion(String question) {
        // Show question to user
        System.out.println(question);

        // Read user's answer and convert it to lower case
        String input = System.console().readLine("Please type either Y[es] or N[o] to continue: ").toLowerCase();

        // Deal with the user input
        if(input.equals("y") || input.equals("yes")){
            return true;
        }else if(input.equals("n") || input.equals("no")){
            return false;
        }else{
            System.out.println("\nIncorrect answer! Please try again.");
            return askQuestion(question);
        }
    }

    public static ArrayList<Integer> rangeArray(int min, int max) {
        int diff = max - min + 1;
        ArrayList<Integer> range = new ArrayList<Integer>();

        for(int i = 0; i < diff; i++) {
            range.add(i + min);
        }

        return range;
    }
}
