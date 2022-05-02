
public class PoissonDstrSolver {

	private double lambda;
	private double y;
	private String operation;
	/**
	 * @param lambda
	 * @param y
	 * @param operation
	 */
	public PoissonDstrSolver(double lambda, double y, String operation) {
	
		this.lambda = lambda;
		this.y = y;
		this.operation = operation;
	}
	public double factorial(double num) {
		if (num == 0) {
			return 1;
		}
		else {
			return(num * factorial(num - 1));
		}
		
	}
	public double calc() {
		double ans = 0;
		if (getOperation().equals("=")) {
			ans = ((Math.pow(getLambda(), getY())) / (factorial(getY()))) * Math.pow(Math.E, (-1*getLambda()));
		}
		else if (getOperation().equals("<=")) {
			double x = getY();
			while (x >= 0) {
				ans += ((Math.pow(getLambda(), x)) / (factorial(x))) * Math.pow(Math.E, (-1*getLambda()));
				x--;
			}
			
		}
		else if (getOperation().equals(">=")) {
			double x = getY()-1;
			while (x >= 0) {
				ans += ((Math.pow(getLambda(), x)) / (factorial(x))) * Math.pow(Math.E, (-1*getLambda()));
				x--;
			}
			ans = 1 - ans;
		}
		else if (getOperation().equals(">")) {
			double x = getY();
			while (x >= 0) {
				ans += ((Math.pow(getLambda(), x)) / (factorial(x))) * Math.pow(Math.E, (-1*getLambda()));
				x--;
			}
			ans = 1 - ans;
		}
		else if (getOperation().equals("<")) {
			double x = getY()-1;
			while (x >= 0) {
				ans += ((Math.pow(getLambda(), x)) / (factorial(x))) * Math.pow(Math.E, (-1*getLambda()));
				x--;
			}
			
		}
		return ans;
	}
	public double getLambda() {
		return lambda;
	}
	public double getY() {
		return y;
	}
	public String getOperation() {
		return operation;
	}
	
	
	
	
	
}
