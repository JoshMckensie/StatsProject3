import java.util.Random;
import org.apache.commons.math3.analysis.interpolation.LoessInterpolator;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * SmoothGraph is a subclass of OriginalGraph, it changes the way the dataset is created
 * @author jmcke
 *
 */

public class SmoothGraph extends OriginalGraph {
	
	public SmoothGraph() {
		
		super();
		
	}
	/**
	 * First creates salted data, then uses Apache local regression function to smooth data
	 */
	@Override
	public XYDataset createData() {
		
		LoessInterpolator loess = new LoessInterpolator();
		XYSeries points = new XYSeries("Function");
		Random rng = new Random();
		double[] saltedYValues = new double[50];
		double[] xValues = new double[50];
		
		for (int i = 0; i < 50; i++) {
			xValues[i] = i;
			saltedYValues[i] = (Math.sqrt(i)) + (double)rng.nextInt(6);
		}
		double[] smoothYVals = loess.smooth(xValues, saltedYValues);
		
		for (int i = 0; i < 50; i++) {
			points.add((double)i, smoothYVals[i]);
		}
		XYSeriesCollection dataPoints = new XYSeriesCollection(points);
		return dataPoints;
	}
	
}
