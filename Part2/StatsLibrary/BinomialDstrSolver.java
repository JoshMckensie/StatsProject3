/**
 * BinomialDstrSolver solves binomial distribution problems
 * @author Josh Mckensie
 *
 */
public class BinomialDstrSolver {

	private double p;
	private double q;
	private int y;
	private int n;
	private int nMinusY;
	private CombPermSolver cps;
	
	/**
	 * Binomial Distribution 
	 * @param p 
	 * @param q
	 * @param y
	 * @param n
	 */
	public BinomialDstrSolver(double p, double q, int y, int n) {
		
		this.p = p;
		this.q = q;
		this.y = y;
		this.n = n;
		nMinusY = n - y;
		cps = new CombPermSolver(true, (double)n, (double)y);
		
	}
	public double calc() {
		
		cps.combinationSolver();
		return cps.getCombinations() * (Math.pow(getP(), getY())) * (Math.pow(getQ(), getNMinusY()));
		
	}
	public void showResult() {
		
		System.out.println("Binomial Distribution: " + calc());
		
	}
	public int getNMinusY() {
		return nMinusY;
	}
	public double getP() {
		return p;
	}

	public double getQ() {
		return q;
	}

	public int getY() {
		return y;
	}

	public int getN() {
		return n;
	}
	
	
}
