
public class NegativeBinomialDstrSolver {

	private double y;
	private double r;
	private double p;
	private double q;
	
	/**
	 * @param y
	 * @param r
	 * @param p
	 * @param q
	 */
	public NegativeBinomialDstrSolver(double y, double r, double p, double q) {

		this.y = y;
		this.r = r;
		this.p = p;
		this.q = q;
		
	}
	public double calc() {
		
		double ans = 0;
		double yMinus1 = getY() - 1;
		double rMinus1 = getR() - 1;
		
		CombPermSolver cbs = new CombPermSolver(true, yMinus1, rMinus1);
		cbs.combinationSolver();
		ans = cbs.getCombinations() * Math.pow(getP(), getR()) * Math.pow(getQ(), (getY()-getR()));
		
		return ans;
	}
	public double getY() {
		return y;
	}
	public double getR() {
		return r;
	}
	public double getP() {
		return p;
	}
	public double getQ() {
		return q;
	}
	
	
}
