/**
 * GeometricDstrSolver solves geometric distribution problems
 * @author Josh Mckensie
 *
 */
//p(y) = q^y-1p
public class GeometricDstrSolver {

	private double q;
	private double y;
	private double p;
	private String operation;
	
	public GeometricDstrSolver(double q, double y, double p, String operation) {
		
		this.q = q;
		this.y = y;
		this.p = p;
		this.operation = operation;
	}
	public String getOperation() {
		return operation;
	}
	public double calc() {
		
		double ans = 0;
		if (getOperation().equals("=")) {
			ans = (Math.pow(getQ(), (getY()-1))) * getP();
		}
		else if (getOperation().equals(">=")) {
			double y = getY()-1;
			while (y != 0) {
				ans += (Math.pow(getQ(), (y-1))) * getP();
				y--;
			}
			ans = 1 - ans;
		}
		else if (getOperation().equals(">")) {
			double y = getY();
			while (y != 0) {
				ans += (Math.pow(getQ(), (y-1))) * getP();
				y--;
			}
			ans = 1 - ans;
		}
		else if (getOperation().equals("<=")) {
			double y = getY();
			while (y != 0) {
				ans += (Math.pow(getQ(), (y-1))) * getP();
				y--;
			}
		}
		else if (getOperation().equals("<")) {
			double y = getY()-1;
			while (y != 0) {
				ans += (Math.pow(getQ(), (y-1))) * getP();
				y--;
			}
		}
		return ans;
	}
	public double getQ() {
		return q;
	}

	public double getY() {
		return y;
	}

	public double getP() {
		return p;
	}
	
	
}
