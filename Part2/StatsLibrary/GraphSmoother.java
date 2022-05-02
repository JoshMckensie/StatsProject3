import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class GraphSmoother {

	private FileReader fr;
	private FileWriter fw;
	private BufferedWriter bw;
	private BufferedReader br;
	private double[] yVals;
	private ArrayList<Double> yValsSmooth;
	private int range;
	
	public GraphSmoother(int range) {
		
		try {
			fr = new FileReader("Salter.csv");
			fw = new FileWriter("Smooth.csv");
		}
		catch(Exception e){
			System.out.println("ERROR: " + e.toString());
		}
		br = new BufferedReader(fr);
		bw = new BufferedWriter(fw);
		this.range = range;
		yVals = new double[51];
		yValsSmooth = new ArrayList<>();
		
		
	}
	public void yVals() {
		String comma = ",";
		String line;
		int lineNum = 0;
		try {
			while((line = br.readLine()) != null) {
				if(lineNum != 0) {
					String temp[] = line.split(comma);
					setYValues(lineNum-1, (Double.parseDouble(temp[1])));
				}
				lineNum++;
			}
		}
		catch(Exception e){
			System.out.println("ERROR: " + e.toString());
		}
		try {
			br.close();
		}
		catch(Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
	public void setYValues(int index, double yValue) {
		
		yVals[index] = yValue;
		
	}
	public double getYValues(int index) {
		return yVals[index];
	}
	public double[] getYArray() {
		return yVals;
	}
	public int getRange() {
		return range;
	}
	public void smoothGraph() {
		int count = 0;
		double y = 0;
		for(int i = 0; i < getYArray().length; i++) {
			y += getYValues(i);
			count++;
			if (count == getRange()) {
				setSmoothY(y / (double)getRange());
				count = 0;
				y = 0;
			}
		}
	}
	public ArrayList<Double> getSmoothArr() {
		return yValsSmooth;
	}
	public double getSmoothY(int index) {
		return yValsSmooth.get(index);
	}
	public void setSmoothY(double val) {
		yValsSmooth.add(val);
	}
	public void singleLine(){
		String header = "X, Y\n";
		for (int i = 0; i < getSmoothArr().size(); i++) {
			if (i == 0) {
				
				try {
					bw.write(header);
				}
				catch(Exception e) {
					System.out.println("Write out error: " + e.toString());
				}
				try {
					bw.write((i) + "," + getSmoothY(i) + "\n");
				}
				catch(Exception e) {
					System.out.println("Write out error: " + e.toString());
				}
				
			}
			else {
				
				try {
					bw.write((i) + "," + getSmoothY(i) + "\n");
				}
				catch(Exception e) {
					System.out.println("Write out error: " + e.toString());
				}
				
			}
		}
		try {
			bw.close();
		}
		catch(Exception e) {
			System.out.println("Error: " + e.toString());
		}
		
	}
	
}
