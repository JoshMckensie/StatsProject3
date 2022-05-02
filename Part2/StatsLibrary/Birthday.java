

public class Birthday {

	private int numPeople;
	private String[] peopleArray;
	private Person p;
	private int runs;
	
	public Birthday(int ppl, int r) {
		
		runs = r;
		numPeople = ppl;
		peopleArray = new String[ppl];
		p = new Person();
		
	}
	public String[] getPeopleArray() {
		return peopleArray;
	}
	public void setPeopleArray(String[] peopleArray) {
		this.peopleArray = peopleArray;
	}
	public void peopleList() {
		
		for (int i = 0; i < getNumPeople(); i++) {
			peopleArray[i] = p.createPerson();
		}
		
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getNumPeople() {
		return numPeople;
	}

	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	} 
	public boolean checkDuplicates(String[] ppl) {
		
		boolean duplicate = false;
		
		for (int i = 0; i < getNumPeople(); i++) {
			for (int j = 1; j < getNumPeople(); j++) {
				if (ppl[i].equals(ppl[j]) && i != j) {
					duplicate = true;
					break;
				}
			}
		}
		return duplicate;
	}
	public void sim() {
		
		int sharedBirthdays = 0;
		for (int i = 0; i < getRuns(); i++) {
			
			peopleList();
			if (checkDuplicates(getPeopleArray()) == true) {
				sharedBirthdays++;
			}	
		}
		System.out.print("Shared Birthday " + ((double)sharedBirthdays / (double)getRuns()) * 100);
		System.out.println("% of the time, with " + getNumPeople() + " people in " + getRuns() + " runs.");
		
	}
	
	
}
