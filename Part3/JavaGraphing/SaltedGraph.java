import java.util.Random;

/**
 * SaltedGraph is a subclass of OriginalGraph, it changes the method that returns y values
 * @author jmcke
 *
 */

 public class SaltedGraph extends OriginalGraph {

	public SaltedGraph() {
		
		super();
	}
	/**
	 * function first computes the sqrt, then will add a random number to the y value 
	 */
	@Override
	public double function(double num) {
		
		Random rng = new Random();
		
		return (Math.sqrt(num)) + (double)rng.nextInt(6);
		
	}
	
}
