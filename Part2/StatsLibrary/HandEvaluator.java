import java.util.ArrayList;

/**
 * HandEvaluator determines the probability of poker hands.
 * @author Josh Mckensie
 *
 */

public class HandEvaluator {
	
	private ArrayList<Card> hand;
	private int[] handNumbers;
	private int[] handSuites;
	private Deck deck;
	private int pairCount, twoPairCount, threeCount, straightCount, flushCount, fullhouseCount, fourCount, royalCount;
	
	/**
	 * hand will hold the 7 cards that will be evaluated.
	 * handNumbers will count the frequency of a card number in each hand.
	 * handSuites will count the frequency of a card suite in each hand.
	 * deck is a generated set of 52 cards
	 * All count variables keep track of which hand was evaluated.
	 */
	public HandEvaluator() {
		hand = new ArrayList<>();
		handNumbers = new int[13];
		handSuites = new int[4];
		deck = new Deck();
		pairCount = 0;
		twoPairCount = 0;
		threeCount = 0;
		straightCount = 0;
		flushCount = 0;
		fullhouseCount = 0;
		fourCount = 0;
		royalCount = 0;
		
	}
	/**
	 * setHand() shuffles the deck and draws the cards for a single hand.
	 */
	public void setHand() {
	
		deck.shuffle(deck.getDeck());
		for (int i = 0; i < 10; i++) {
			if (i == 2 || i == 6 || i == 8) {
				//Cards that are discarded (Once before flop, once before turn and once before river)
				deck.drawCard();
			}
			else {
				//Card is added into the hand
				hand.add(deck.drawCard());
			}
		}
	}
	/**
	 * Retrieves the hand.
	 * @return the hand ArrayList
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}
	/**
	 * handNumbers() creates an array that corresponds to number frequency.
	 * Index 0 corresponds to an Ace through index 12 that corresponds to a King.
	 * An index is incremented for each number that appears in a hand.
	 */
	public void handNumbers() {
		
		int num;
		int[] temp = new int[13];
		for (int i = 0; i < getHand().size(); i++) {
			num = getHand().get(i).getNumber();
			temp[num-1]++;
		}
		setHandNumbers(temp);
	}
	/**
	 * Retrieves handNumbers
	 * @return the array handNumbers
	 */
	public int[] getHandNumbers() {
		return handNumbers;
	}
	/**
	 * Used to set the handNumbers array
	 * @param handNumbers an array that will be used to set handNumbers
	 */
	public void setHandNumbers(int[] handNumbers) {
		this.handNumbers = handNumbers;
	}
	/**
	 * handSuites() is used to track suite frequency.
	 * Each index corresponds to a card suite.
	 * An index is incremented when its corresponding suite appears in hand.
	 * 
	 */
	public void handSuites() {
		
		int[] temp = new int[4];
		String suite = "";
		for (int i = 0; i < getHand().size(); i++) {
			
			suite = getHand().get(i).getSuite();
			if (suite.equals("Spades")) {
				temp[0]++;
			}
			else if (suite.equals("Clubs")) {
				temp[1]++;
			}
			else if (suite.equals("Hearts")) {
				temp[2]++;
			}
			else {
				temp[3]++;
			}
		}
		setHandSuites(temp);
	}
	/**
	 * Retrieves handSuites
	 * @return handSuites array
	 */
	public int[] getHandSuites() {
		return handSuites;
	}
	/**
	 * Sets the handSuites array
	 * @param handSuites an array that will be used to set handSuites
	 */
	public void setHandSuites(int[] handSuites) {
		this.handSuites = handSuites;
	}
	/**
	 * Checks for a single pair in a hand
	 * If the handNumbers array has exactly one index with a frequency of 2, then pairCount is incremented.
	 */
	public void checkPair() {
		
		int numOfPairs = 0;
		for (int i = 0; i < getHandNumbers().length; i++) {
			if (getHandNumbers()[i] == 2) {
				numOfPairs++;
			}
		}
		if (numOfPairs == 1) {
			pairCount++;
		}
		
	}
	/**
	 * Checks for two pairs in a hand
	 * If the handNumbers array has two indexes with a frequency of 2, then twoPairCount is incremented
	 */
	public void checkTwoPair() {
		int numOfPairs = 0;
		for (int i = 0; i < getHandNumbers().length; i++) {
			if (getHandNumbers()[i] == 2) {
				numOfPairs++;
			}
		}
		if (numOfPairs == 2) {
			twoPairCount++;
		}
	}
	/**
	 * Checks for three of a kind in a hand
	 * If handNumber array has an index with frequency of 3, then threeCount is incremented
	 */
	public void checkThreeOfKind() {
		boolean three = false;
		for (int i = 0; i < getHandNumbers().length; i++) {
			if (getHandNumbers()[i] == 3) {
				three = true;
			}
		}
		if (three) {
			threeCount++;
		}
	}
	/**
	 * Checks for a straight in a hand
	 * If handNumbers array has five consecutive indexes with at least a value of 1, then straightCount is incremented
	 */
	public void checkStraight() {
		
		int count = 0;
		for (int i = 0; i < 9; i++) {
			if (getHandNumbers()[i] >= 1) {
				count++;
				for (int j = i + 1; j < i + 5; j++) {
					if (getHandNumbers()[j] >= 1) {
						count++;
					}
					else {
						count = 0;
						break;
					}
				}
			}
			if (count == 5) {
				break;
			}
		}
		if (count >= 5) {
			straightCount++;
		}
	}
	/**
	 * Checks for a fullhouse in a hand
	 * If handNumbers array contains both a pair and three of a kind, then fullhouseCount is incremented
	 */
	public void checkFullHouse() {
		
		boolean three = false;
		boolean two = false;
		for (int i = 0; i < getHandNumbers().length; i++) {
			if (getHandNumbers()[i] == 3) {
				three = true;
			}
			if (getHandNumbers()[i] == 2) {
				two = true;
			}
		}
		if (three && two) {
			fullhouseCount++;
		}
		
	}
	/**
	 * Checks for a flush in a hand
	 * If handSuites array has a value of at least 5, then flushCount is incremented.
	 */
	public void checkFlush() {
		
		boolean flush = false;
		for (int i = 0; i < getHandSuites().length; i++) {
			if (getHandSuites()[i] >= 5) {
				flush = true;
				break;
			}
		}
		if (flush) {
			flushCount++;
		}
		
	}
	/**
	 * Checks for a four of a kind in a hand
	 * If handNumbers array has a value of 4, then fourCount is incremented
	 */
	public void checkFourOfKind() {
		
		boolean four = false;
		for (int i = 0; i < getHandNumbers().length; i++) {
			if (getHandNumbers()[i] == 4) {
				four = true;
			}
		}
		if (four) {
			fourCount++;
		}
		
	}
	/**
	 * Additional Method, checks for a straight of 10 through Ace with the same suite
	 * First the method will check for a flush, if there is a flush then it will check for a 10-Ace, 
	 * lastly it will determine if 10-Ace are all of the same suite.
	 * If these checks are passed then royalCount is incremented
	 */
	public void checkRoyalFlush() {
		
		boolean flush = false;
		int count = 0;
		int valOfI = 0;
		for (int i = 0; i < getHandSuites().length; i++) {
			if (getHandSuites()[i] >= 5) {
				flush = true;
				break;
			}
		}
		if (flush) {
			if (getHandNumbers()[9] >= 1 && getHandNumbers()[0] >= 1) {
				count = 2;
				for (int i = 10; i < 13; i++) {
					if (getHandNumbers()[i] >= 1) {
						count++;
					}
					else {
						count = 0;
						break;
					}
				}
			}
		}
		if (flush && count == 5) {
			
			int x = 0;
			int[] royalFlushNums = new int[] {10, 11, 12, 13, 1}; 
			String suite = "";
			if (valOfI == 0) {
				suite = "Spades";
			}
			else if (valOfI == 1) {
				suite = "Clubs";
			}
			else if (valOfI == 2) {
				suite = "Hearts";
			}
			else {
				suite = "Diamonds";
			}
			
			for (int i = 0; i < getHand().size(); i++) {
				for (int j = 0; j < royalFlushNums.length; j++) {
					if (getHand().get(i).getNumber() == royalFlushNums[j] && getHand().get(i).getSuite().equals(suite)) {
						x++;
					}
				}
			}
			if (x == 5) {
				royalCount++;
			}
			
					
		}
		
	}
	/**
	 * Will reset all values after a hand is finished.
	 */
	public void clearHand() {
		
		deck.getShuffledDeck().clear();
		getHand().clear();
		for (int i = 0; i < getHandNumbers().length; i++) {
			getHandNumbers()[i] = 0;
		}
		for (int i = 0; i < getHandSuites().length; i++) {
			getHandSuites()[i] = 0;
		}
		
	}
	public int getPairCount() {
		return pairCount;
	}

	public int getTwoPairCount() {
		return twoPairCount;
	}

	public int getThreeCount() {
		return threeCount;
	}

	public int getStraightCount() {
		return straightCount;
	}

	public int getFlushCount() {
		return flushCount;
	}

	public int getFullhouseCount() {
		return fullhouseCount;
	}
	public int getFourCount() {
		return fourCount;
	}

	public int getRoyalCount() {
		return royalCount;
	}
	/**
	 * Each hand is checked 10000 times, the probability of each hand is displayed when finished
	 */
	public void sim() {
		
		int runs = 10000;
		for (int i = 0; i < runs; i++) {
			setHand();
			handNumbers();
			handSuites();
			checkPair();
			clearHand();
		}
		for (int i = 0; i < runs; i++) {
			setHand();
			handNumbers();
			handSuites();
			checkTwoPair();
			clearHand();
		}
		for (int i = 0; i < runs; i++) {
			setHand();
			handNumbers();
			handSuites();
			checkThreeOfKind();
			clearHand();
		}
		for (int i = 0; i < runs; i++) {
			setHand();
			handNumbers();
			handSuites();
			checkStraight();
			clearHand();
		}
		for (int i = 0; i < runs; i++) {
			setHand();
			handNumbers();
			handSuites();
			checkFlush();
			clearHand();
		}
		for (int i = 0; i < runs; i++) {
			setHand();
			handNumbers();
			handSuites();
			checkFullHouse();
			clearHand();
		}
		for (int i = 0; i < runs; i++) {
			setHand();
			handNumbers();
			handSuites();
			checkFourOfKind();
			clearHand();
		}
		for (int i = 0; i < runs; i++) {
			setHand();
			handNumbers();
			handSuites();
			checkRoyalFlush();
			clearHand();
		}
		System.out.println("Pairs: " + ((double)getPairCount() / (double) runs)* 100 + "%");
		System.out.println("Two Pairs: " + ((double) getTwoPairCount() / (double) runs)* 100 + "%");
		System.out.println("Three of a kind: " + ((double) getThreeCount() / (double) runs)* 100 + "%");
		System.out.println("Straight: " + ((double) getStraightCount() / (double) runs)* 100 + "%");
		System.out.println("Flush: " + ((double) getFlushCount() / (double) runs)* 100 + "%");
		System.out.println("FullHouse: " + ((double) getFullhouseCount() / (double) runs)* 100 + "%");
		System.out.println("Four of a kind: " + ((double) getFourCount() / (double) runs) * 100 + "%");
		System.out.println("Royal Flush: " + ((double) getRoyalCount() / (double) runs) * 100 + "%");
	}
	
	
	
}
