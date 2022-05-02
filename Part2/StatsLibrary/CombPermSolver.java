
public class CombPermSolver {

	private double combinations;
	private double permutations;
	private double n;
	private double r;
	private double nMinusR;
	private boolean isCombination;
	
	public CombPermSolver(boolean isCombination, double n, double r) {
		
		this.isCombination = isCombination;
		this.n = n;
		this.r = r;
		combinations = 0;
		permutations = 0;
		nMinusR = n - r;
		
	}
	public double factorial(double num) {
		if (num == 0) {
			return 1;
		}
		else {
			return(num * factorial(num - 1));
		}
		
	}
	public void setNMinusRFactorial(double num) {
		nMinusR = num;
	}
	public void setNFactorial(double num) {
		
		n = num;	
	}
	public void setRFactorial(double num) {
		r = num;
	}
	public void setCombinations(double num) {
		combinations = num;
	}
	public void setPermutation(double num) {
		permutations = num;
	}
	public double getCombinations() {
		return combinations;
	}
	public double getPermutations() {
		return permutations;
	}
	public double getN() {
		return n;
	}
	public double getR() {
		return r;
	}
	public double getNMinusR() {
		return nMinusR;
	}
	public boolean getIsCombination() {
		return isCombination;
	}
	public double combinationSolver() {
		
		setNMinusRFactorial(factorial(getNMinusR()));
		setNFactorial(factorial(getN()));
		setRFactorial(factorial(getR()));
		setCombinations((getN() / (getR() * getNMinusR())));
		return getCombinations();
		
	}
	public double permutationSolver() {
		
		setNMinusRFactorial(factorial(getNMinusR()));
		setNFactorial(factorial(getN()));
		setPermutation(getN() / getNMinusR());
		return getPermutations();
		
	}
	public void calculate() {
		
		if (getIsCombination()) {
			combinationSolver();
			System.out.println("Combinations: " + getCombinations());
		}
		else {
			permutationSolver();
			System.out.println("Permutations: " + getPermutations());
		}
	}
}
