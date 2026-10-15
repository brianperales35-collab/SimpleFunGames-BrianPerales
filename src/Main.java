import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        War war = new War();
        WordScramble scramble = new WordScramble();
        while (true) {

            System.out.println("\n >>> Brian's GAME MENU <<< ");
            System.out.println("1. War CardGame");
            System.out.println("2. Word Scramble");
            System.out.println("3. View High Scores");
            System.out.println("4. Exit");

            System.out.print("Choose: ");

            try {
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        war.play();
                        break;

                    case 2:
                        scramble.play();
                        break;

                    case 3:
                        ScoreTracker.readScores();
                        break;

                    case 4:
                        System.out.println("Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option.");
                }

            } catch (Exception e) {
                System.out.println("Please enter a number.");
                input.nextLine();
            }
        }
    }
}