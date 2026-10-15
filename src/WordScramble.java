import java.util.*;

public class WordScramble {

    // Added 20+ Words to unscramble: list of words that are all Millikin University themed (School/Academic terms)
    private String[] words = {
            "Millikin", "Football", "University", "Programming",
            "Coding", "Scramble", "Soccer", "Cheerleading", "Basketball",
            "Soccer", "Baseball", "Campus", "Student", "Alumni", " Education",
            "Learning", "Professor", "College", "Freshman", "Sophomore",
            "Junior", "Senior", "Graduate", "Academics", "Degree", "Diploma",
            "Lecture", "Honors", "Dean", "Major", "Minor", "Class", "Library",
            "Scholarship", "Career", "Internships", "Dorms", "Bachelors", "Track",
            "Homework", "Syllabus"
    };

    public void play() {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        String word = words[rand.nextInt(words.length)];
        String scrambled = scramble(word);

        int attempts = 0;

        System.out.println("\n >>> WORD SCRAMBLE <<< ");

        while (true) {

            System.out.println("Unscramble: " + scrambled);
            System.out.print("Guess: ");

            String guess = input.nextLine();
            attempts++;

            if (guess.equalsIgnoreCase(word)) {

                System.out.println("That is Correct!");

                // Fixed: A correct first guess earns 100 points; each extra guess costs 10 points.
                int score = Math.max(100 - (attempts - 1) * 10, 10);
                System.out.println("Score: " + score);

                System.out.print("Enter username: ");
                String name = input.nextLine();

                ScoreTracker.saveScore(name, score);

                break;

            } else {
                System.out.println("Unfortunately, that is wrong, try again.");
            }
        }
    }

    private String scramble(String word) {

        char[] arr = word.toCharArray();

        String scrambled;
        do {
            for (int i = arr.length - 1; i > 0; i--) {
                int j = (int) (Math.random() * (i + 1));

                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            scrambled = new String(arr);
        } while (scrambled.equalsIgnoreCase(word));

        return scrambled;
    }
}