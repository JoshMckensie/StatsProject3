import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * OriginalGraph is used to create a dataset and plot it as a line graph
 * @author jmcke
 *
 */
public class OriginalGraph{

	private JFreeChart chart;
	private XYDataset data;
	
	public OriginalGraph() {
		
		data = createData();
		chart = ChartFactory.createXYLineChart("Square Root Function", "X Values", "Y Values", data, PlotOrientation.VERTICAL, true, true, false);
		
	}
	/**
	 * 
	 * @param num input x value for square root function
	 * @return y value
	 */
	public double function(double num) {
		
		return Math.sqrt(num);
		
	}
	/**
	 * 
	 * @return the XYDataset object, data
	 */
	public XYDataset getData() {
		return data;
	}
	/**
	 * 
	 * @return the JFreeChart object, chart
	 */
	public JFreeChart getChart() {
		return chart;
	}
	/**
	 * Generates data points that correspond to the square root function
	 * @return the collection of data points
	 */
	public XYDataset createData() {
		
		XYSeries points = new XYSeries("Function");
		
		for (int i = 0; i < 50; i++) {
			points.add((double)i, function((double)i));
		}
		
		XYSeriesCollection dataPoints = new XYSeriesCollection(points);
		return dataPoints;
	}
	/**
	 * Display the chart
	 */
	public void showChart() {
		
		ChartFrame frame = new ChartFrame("Square Root", getChart());
		frame.setSize(1000, 600);
		frame.setVisible(true);
	}
	
}
