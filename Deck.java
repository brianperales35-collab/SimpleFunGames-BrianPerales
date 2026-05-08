import java.util.*;

public class Deck {

    // Stores all cards in the deck
    private List<GameCard> cards = new ArrayList<>();

    // Card values
    private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private String[] ranks = {
            "2","3","4","5","6","7","8","9","10",
            "J","Q","K","A"
    };

    // Cards are shuffled
    public Deck() {

        // Full set of cards provided
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new GameCard(suit, rank));
            }
        }

        // Shuffled cards so it doesn't give the same card everytime
        Collections.shuffle(cards);
    }

    // Draws a card
    public GameCard drawCard() {

        // Makes sure nothing goes wrong
        if (cards.isEmpty()) {
            System.out.println("Deck is empty!");
            return null;
        }

        // Gets rid of the previous card
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }
}