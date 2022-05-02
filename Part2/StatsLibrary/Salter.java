import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class Salter {

	private FileReader fr;
	private FileWriter fw;
	private BufferedWriter bw;
	private BufferedReader br;
	private Random rng;
	private double[] yVals;
	private int bound;
	
	public Salter(int bound) {
		
		try {
			fr = new FileReader("SqrtFunction.csv");
			fw = new FileWriter("Salter.csv");
		}
		catch(Exception e){
			System.out.println("ERROR: " + e.toString());
		}
		rng = new Random();
		br = new BufferedReader(fr);
		bw = new BufferedWriter(fw);
		yVals = new double[51];
		this.bound = bound;
		
	}
	public void yVals() {
		String comma = ",";
		String line;
		int lineNum = 0;
		try {
			while((line = br.readLine()) != null) {
				if(lineNum != 0) {
					String temp[] = line.split(comma);
					setYValues(lineNum-1, (Double.parseDouble(temp[1]) + (double)rng.nextInt(getBound())));
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
	public int getBound() {
		return bound;
	}
	public void singleLine(){
		String header = "X, Y\n";
		for (int i = 0; i <= 50; i++) {
			if (i == 0) {
				
				try {
					bw.write(header);
				}
				catch(Exception e) {
					System.out.println("Write out error: " + e.toString());
				}
				try {
					bw.write((i) + "," + getYValues(i) + "\n");
				}
				catch(Exception e) {
					System.out.println("Write out error: " + e.toString());
				}
				
			}
			else {
				
				try {
					bw.write((i) + "," + getYValues(i) + "\n");
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


