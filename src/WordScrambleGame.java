import java.util.*;

public class WordScrambleGame {

    //list of words that are possible to get
    private String[] words = {
            "Millikin", "Football", "Greenwall", "Programming",
            "Coding", "Scramble", "Soccer", "Cheerleading"
    };

    public void play() {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        String word = words[rand.nextInt(words.length)];
        String scrambled = scramble(word);

        int attempts = 0;

        System.out.println("\n=== WORD SCRAMBLE ===");

        while (true) {

            System.out.println("Unscramble: " + scrambled);
            System.out.print("Guess: ");

            String guess = input.nextLine();
            attempts++;

            if (guess.equalsIgnoreCase(word)) {

                System.out.println("Correct!");

                int score = Math.max(100 - attempts * 10, 10);
                System.out.println("Score: " + score);

                System.out.print("Enter name: ");
                String name = input.nextLine();

                ScoreFileHandler.saveScore(name, score);

                break;

            } else {
                System.out.println("Wrong, try again.");
            }
        }
    }

    private String scramble(String word) {

        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int j = (int)(Math.random() * arr.length);

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return new String(arr);
    }
}