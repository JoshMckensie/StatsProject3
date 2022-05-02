
public class HypergeometricDstrSolverTester {

	public static void main(String[] args) {
		
		HypergeometricDstrSolver hds = new HypergeometricDstrSolver(6, 4, 7, 20, "<=");
		System.out.println(hds.calc());

	}

}
