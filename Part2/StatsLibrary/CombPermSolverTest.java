
public class CombPermSolverTest {

	public static void main(String[] args) {
		
		CombPermSolver cps = new CombPermSolver(false, 5, 2);
		CombPermSolver cps1 = new CombPermSolver(true, 5, 2);
		
		cps.calculate();
		cps1.calculate();

	}

}
