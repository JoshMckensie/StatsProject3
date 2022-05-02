
public class HypergeometricDstrSolver {

	private double r;
	private double y;
	private double lowerN;
	private double upperN;
	private String operation;
	private double rAndY;
	private double nDif;
	private double nAndN;
	
	
	
	
	public HypergeometricDstrSolver(double r, double y, double lowerN, double upperN, String operation) {
		
		this.r = r;
		this.y = y;
		this.lowerN = lowerN;
		this.upperN = upperN;
		this.operation = operation;
		double rAndY = 0;
		double nDif = 0;
		double nAndN = 0;
		
		
	}
	public double calc() {
		
		double ans = 0;
		
		
		if (getOperation().equals("=")) {
			double x = getY();
			CombPermSolver cbs1 = new CombPermSolver(true, getR(), x);
			CombPermSolver cbs2 = new CombPermSolver(true, (getUpperN()-getR()), (getLowerN()-x));
			CombPermSolver cbs3 = new CombPermSolver(true, getUpperN(), getLowerN());
			cbs1.combinationSolver();
			cbs2.combinationSolver();
			cbs3.combinationSolver();
			double rAndY = cbs1.getCombinations();
			double nDif = cbs2.getCombinations();
			double nAndN = cbs3.getCombinations();
			ans = (rAndY * nDif) / nAndN;
		}
		else if (getOperation().equals("<")) {
			double x = getY()-1;
			while (x >= 0) {
				CombPermSolver cbs1 = new CombPermSolver(true, getR(), x);
				CombPermSolver cbs2 = new CombPermSolver(true, (getUpperN()-getR()), (getLowerN()-x));
				CombPermSolver cbs3 = new CombPermSolver(true, getUpperN(), getLowerN());
				cbs1.combinationSolver();
				cbs2.combinationSolver();
				cbs3.combinationSolver();
				double rAndY = cbs1.getCombinations();
				double nDif = cbs2.getCombinations();
				double nAndN = cbs3.getCombinations();
				ans += (rAndY * nDif) / nAndN;
				x--;
			}
		}
		else if (getOperation() == "<=") {
			double x = getY();
			while (x >= 0) {
				CombPermSolver cbs1 = new CombPermSolver(true, getR(), x);
				CombPermSolver cbs2 = new CombPermSolver(true, (getUpperN()-getR()), (getLowerN()-x));
				CombPermSolver cbs3 = new CombPermSolver(true, getUpperN(), getLowerN());
				cbs1.combinationSolver();
				cbs2.combinationSolver();
				cbs3.combinationSolver();
				double rAndY = cbs1.getCombinations();
				double nDif = cbs2.getCombinations();
				double nAndN = cbs3.getCombinations();
				ans += (rAndY * nDif) / nAndN;
				x--;
			}
		}
		else if (getOperation() == ">") {
			double x = getY();
			while (x >= 0) {
				CombPermSolver cbs1 = new CombPermSolver(true, getR(), x);
				CombPermSolver cbs2 = new CombPermSolver(true, (getUpperN()-getR()), (getLowerN()-x));
				CombPermSolver cbs3 = new CombPermSolver(true, getUpperN(), getLowerN());
				cbs1.combinationSolver();
				cbs2.combinationSolver();
				cbs3.combinationSolver();
				double rAndY = cbs1.getCombinations();
				double nDif = cbs2.getCombinations();
				double nAndN = cbs3.getCombinations();
				ans += (rAndY * nDif) / nAndN;
				x--;
			}
			ans = 1 - ans;
			
		}
		else if (getOperation() == ">=") {
			double x = getY()-1;
			while (x >= 0) {
				CombPermSolver cbs1 = new CombPermSolver(true, getR(), x);
				CombPermSolver cbs2 = new CombPermSolver(true, (getUpperN()-getR()), (getLowerN()-x));
				CombPermSolver cbs3 = new CombPermSolver(true, getUpperN(), getLowerN());
				cbs1.combinationSolver();
				cbs2.combinationSolver();
				cbs3.combinationSolver();
				double rAndY = cbs1.getCombinations();
				double nDif = cbs2.getCombinations();
				double nAndN = cbs3.getCombinations();
				ans += (rAndY * nDif) / nAndN;
				x--;
			}
			ans = 1 - ans;
		}
		return ans;
		
	}
	
	public double getR() {
		return r;
	}

	public double getY() {
		return y;
	}

	public double getLowerN() {
		return lowerN;
	}

	public double getUpperN() {
		return upperN;
	}
	public String getOperation() {
		return operation;
	}
}
