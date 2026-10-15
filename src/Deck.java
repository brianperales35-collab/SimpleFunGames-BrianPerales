import java.util.*;

public class Deck {

    // The deck of cards
    private List<Cards> cards = new ArrayList<>();

    // All the possible cards available
    private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9",  "10", "J", "Q", "K", "A"
    };

    // Cards are shuffled
    public Deck() {

        // Set of Cards
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Cards(suit, rank));
            }
        }

        // Shuffled cards so it doesn't give the same card everytime
        Collections.shuffle(cards);
    }

    // Draws a card to start the game
    public Cards drawCard() {

        if (cards.isEmpty()) {
            System.out.println("Deck is empty!");
            return null;
        }

        // Gets rid of the used card
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }
}