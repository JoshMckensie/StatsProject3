import java.util.Random;

public class MonteCarlo {

	private String[] curtains;
	private int choice;
	private Random rand;
	private boolean changeChoice;
	private int dudIndex;
	private int wins;
	private int totalRuns;
	
	public MonteCarlo(boolean changeChoice){
		curtains = new String[] {"Prize", "Dud1", "Dud2"};
		choice = 1;
		rand = new Random();
		this.changeChoice = changeChoice;
		wins = 0;
		totalRuns = 0;
	}
	public int getWins() {
		return wins;
	}
	public int getTotalRuns() {
		return totalRuns;
	}
	public boolean getChangeChoice() {
		return changeChoice;
	}
	public String[] getCurtains() {
		return curtains;
	}
	//Random Curtain 0-2
	public void pickCurtain() {
		choice = rand.nextInt(3);
	}
	//Return Curtain choice
	public int getChoice() {
		return choice;
	}
	//Set Curtain choice
	public void setChoice(int chc) {
		choice = chc;
	}
	//Shuffle items behind curtain
	public void shuffleCurtains(String[] curt) {
		
		for (int i = curt.length-1; i > 0; i--) {
			
			int j = rand.nextInt(i+1);
			String temp = curt[i];
			curt[i] = curt[j];
			curt[j] = temp;
			
		}
		
	}
	//Returns an array with index's of the two duds
	public int[] getDudIndexs(String[] curt) {
		
		int[] duds = new int[2];
		int j = 0;
		for (int i = 0; i < curt.length; i++) {
			//if curtain array at i is equal to "Dud1" or "Dud2", then add index of dud into dud array
			if (curt[i].equals("Dud1") || curt[i].equals("Dud2")) {
				duds[j] = i;
				j++;
			}
		}
		return duds;
		
	}
	//Determines which curtain will be shown
	public void showDud(int[] duds, int chc) {
		
		int dudCurtain = 0;
		//if choice equals the integer at duds[0], then set to other curtain(duds[1])
		if (chc == duds[0]) {
			dudCurtain = duds[1];
		}
		//if choice equals the integer at duds[1], then set to other curtain(duds[0])
		if (chc == duds[1]) {
			dudCurtain = duds[0];
		}
		//if choice does not equal either duds[0] or duds[1], then randomly pick either door.
		if (chc != duds[0] && chc != duds[1]) {
			dudCurtain = duds[rand.nextInt(duds.length)];
		}
		
		dudIndex = dudCurtain;
	}
	//return index of dud curtain that will be shown
	public int getDudIndex() {
		return dudIndex;
	}
	public void changeCurtainChoice(boolean chg) {
		
		int dudCurtain = getDudIndex();
		int originalChoice = getChoice();
		//if contestant wants to change curtain
		if (chg) {
			//if first choice + the dudCurtain shown = 1, then index 2 (or third curtain),
			//is the only curtain available to switch to
			if (originalChoice + dudCurtain == 1) {
				setChoice(2);
			}
			//if first choice + the dudCurtain shown = 2, then index 1 (or second curtain),
			//is the only curtain available to switch to
			if (originalChoice + dudCurtain == 2) {
				setChoice(1);
			}
			//Last option would be index 0, (or first curtain)
			else {
				setChoice(0);
			}
			
		}
		
	}
	public void stats(int chc, String[] curt) {
		if (curt[chc].equals("Prize")) {
			wins++;
		}
		totalRuns++;
	}
	public void showOutcome() {
		
		if (getChangeChoice()) {
			System.out.println("Always Change Choice: %" + (double)getWins() / (double)getTotalRuns() * 100);
		}
		else {
			System.out.println("Never Change Choice: %" + (double)getWins() / (double)getTotalRuns() * 100);
		}
		
	}
	public void simulation() {
		
		for (int i = 0; i < 10000; i++) {
			
			shuffleCurtains(getCurtains());
			pickCurtain();
			showDud(getDudIndexs(getCurtains()), getChoice());
			changeCurtainChoice(getChangeChoice());
			stats(getChoice(), getCurtains());
			
		}
		showOutcome();
		
	}
	
	
}
