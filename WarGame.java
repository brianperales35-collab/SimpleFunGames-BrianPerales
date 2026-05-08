public class WarGame {

    public void play() {

        Deck deck = new Deck();

        java.util.Queue<GameCard> player = new java.util.LinkedList<>();
        java.util.Queue<GameCard> cpu = new java.util.LinkedList<>();

        System.out.println("\n=== WAR GAME STARTED ===");

        // Cards are generated once the game mode is selected
        for (int i = 0; i < 26; i++) {

            GameCard p = deck.drawCard();
            GameCard c = deck.drawCard();

            // Alerts something went wrong with the generated cards
            if (p == null || c == null) {
                System.out.println("Deck error: null card detected");
                return;
            }

            player.add(p);
            cpu.add(c);
        }

        int score = 0;

        while (!player.isEmpty() && !cpu.isEmpty()) {

            GameCard p = player.poll();
            GameCard c = cpu.poll();

            if (p == null || c == null) {
                System.out.println("Game stopped: null card found");
                return;
            }

            System.out.println("You: " + p.rank + " vs CPU: " + c.rank);

            int result = compare(p, c);

            if (result > 0) {
                System.out.println("You win round!");
                score++;
                player.add(p);
                player.add(c);

            } else if (result < 0) {
                System.out.println("CPU wins round!");
                cpu.add(p);
                cpu.add(c);

            } else {
                System.out.println("WAR!");
            }

            if (score >= 10) break;
        }

        System.out.println("\nFinal Score: " + score);

        ScoreFileHandler.saveScore("Player", score);
    }

    private int compare(GameCard a, GameCard b) {
        String order = "2345678910JQKA";
        return order.indexOf(a.rank) - order.indexOf(b.rank);
    }
}