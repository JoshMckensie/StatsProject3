import java.util.ArrayList;
import java.util.Random;

/**
 * Deck generates 52 playing cards
 * @author Josh Mckensie
 *
 */

public class Deck {

	private Card singleCard;
	private ArrayList<Card> deckOfCards;
	private ArrayList<Card> shuffledDeck;
	
	/**
	 * suites holds the possible suites of a playing card
	 * numbers holds the possible numbers of a playing card
	 * deckOfCards holds the 52 generated cards, this is generated when the constructor is called
	 * shuffledDeck holds the cards in a random order
	 */
	public Deck() {
		
		String[] suites = new String[] {"Spades", "Clubs", "Hearts", "Diamonds"};
		int[] numbers = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13};
		deckOfCards = new ArrayList<>();
		shuffledDeck = new ArrayList<>();
		for (int i = 0; i < 52; i++) {
			
			if (i < 13) {
				singleCard = new Card(suites[0], numbers[i]);
				deckOfCards.add(singleCard);
			}
			else if (i >= 13 && i < 26) {
				singleCard = new Card(suites[1], numbers[i-13]);
				deckOfCards.add(singleCard);
			}
			else if (i >= 26 && i < 39) {
				singleCard = new Card(suites[2], numbers[i-26]);
				deckOfCards.add(singleCard);
			}
			else {
				singleCard = new Card(suites[3], numbers[i-39]);
				deckOfCards.add(singleCard);
			}
		}
		
	}
	/**
	 * Retrieves the deck
	 * @return deckOfCards ArrayList
	 */
	public ArrayList<Card> getDeck() {
		return deckOfCards;
	}
	/**
	 * Will take the original deck and randomize its order in a new ArrayList
	 * @param deckToShuffle an ArrayList of the originally generated deck
	 */
	public void shuffle(ArrayList<Card> deckToShuffle) {
		
		ArrayList<Card> temp = new ArrayList<>();
		temp.addAll(getDeck());
		Random rng = new Random();
		int randomIndex;
		while (deckToShuffle.size() != 0) {
			randomIndex = rng.nextInt(deckToShuffle.size());
			getShuffledDeck().add(deckToShuffle.remove(randomIndex));		
		}
		getDeck().addAll(temp);
		
	}
	/**
	 * Draws first Card object in the list and removes it
	 * @return Card object from the beginning of shuffledDeck
	 */
	public Card drawCard() {
		Card drawCard = getShuffledDeck().remove(0);
		return drawCard;
	}
	/**
	 * Retrieves the shuffledDeck
	 * @return shuffledDeck ArrayList
	 */
	public ArrayList<Card> getShuffledDeck() {
		return shuffledDeck;
	}
	
}
