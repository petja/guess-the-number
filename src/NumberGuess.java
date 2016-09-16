public class NumberGuess {
    public static void main(String[] args) {
        boolean answer = askQuestion("Is the number divisible with two?");
        System.out.println(answer);
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
