import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class War {

    public void play() {

        Deck deck = new Deck();
        Queue<Cards> player = new LinkedList<>();
        Queue<Cards> cpu = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        //Fixed: Used to automatically generate each round. Now it requires the user to go through each round manually.
        System.out.println("\n >>> WAR GAME <<< ");
        System.out.println("Press Enter to flip cards for each round. Type q and press Enter to quit.");

        // Reduced: Now deals 5 cards instead of 25 to both the user and cpu to make rounds go faster
        // The cards are randomized by Deck before they are dealt.
        for (int i = 0; i < 5; i++) {
            Cards p = deck.drawCard();
            Cards c = deck.drawCard();
            if (p == null || c == null) {
                System.out.println("Deck error");
                return;
            }
            player.add(p);
            cpu.add(c);
        }

        int roundsWon = 0;
        int roundsPlayed = 0;

        while (!player.isEmpty() && !cpu.isEmpty()) {
            System.out.print("\nRound " + (roundsPlayed + 1)
                    + " - press Enter to play (or q to quit): ");
            String command = input.nextLine().trim();
            if (command.equalsIgnoreCase("q")) {
                System.out.println("Game Over");
                break;
            }

            Cards p = player.poll();
            Cards c = cpu.poll();
            if (p == null || c == null) {
                System.out.println("Game stopped");
                break;
            }

            roundsPlayed++;
            System.out.println("Player's card: " + p + " | CPU card: " + c);
            int result = compare(p, c);

            if (result > 0) {
                System.out.println("Player wins the round!");
                roundsWon++;
                player.add(p);
                player.add(c);
            } else if (result < 0) {
                System.out.println("CPU wins the round.");
                cpu.add(p);
                cpu.add(c);
            } else {
                System.out.println("It's a tie! Both cards are the same.");
                // In this simple version, tied cards are removed from play.
            }

            System.out.println("Rounds won by Player: " + roundsWon
                    + " | Player cards: " + player.size()
                    + " | CPU cards: " + cpu.size());
        }

        int score = roundsWon;
        System.out.println("\n >>> WAR GAME OVER <<<");
        System.out.println("Rounds of War: " + roundsPlayed);
        System.out.println("Rounds Player won: " + roundsWon);
        System.out.println("Final Score: " + score);
        ScoreTracker.saveScore("Player", score);
    }

    private int compare(Cards a, Cards b) {
        // Fixed: King, Queens, and Jacks are now fixed to be bigger than 10.
        return rankValue(a.rank) - rankValue(b.rank);
    }

    private int rankValue(String rank) {
        switch (rank) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
            default: return 0;
        }
    }
}
