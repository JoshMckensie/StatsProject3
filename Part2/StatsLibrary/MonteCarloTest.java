
public class MonteCarloTest {

	public static void main(String[] args) {
		
		//No change
		MonteCarlo sim1 = new MonteCarlo(false);
		//Change
		MonteCarlo sim2 = new MonteCarlo(true);
		
		sim1.simulation();
		sim2.simulation();
	}

}
