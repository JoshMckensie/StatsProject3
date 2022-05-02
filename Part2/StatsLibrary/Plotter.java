import java.io.BufferedWriter;
import java.io.FileWriter;

public class Plotter {

	private FileWriter fw;
	private BufferedWriter br;
	
	public Plotter() {
		
		try {
			fw = new FileWriter("SqrtFunction.csv");
			
		}
		catch(Exception e) {
			System.out.println("ERROR: " + e.toString());
		}
		
	}
	
	public double formula(int val) {
		
		return Math.sqrt(val);
		
	}
	
	public void singleLine(){
		br = new BufferedWriter(fw);
		String header = "X, Y\n";
		for (int i = 0; i <= 50; i++) {
			if (i == 0) {
				
				try {
					br.write(header);
				}
				catch(Exception e) {
					System.out.println("Write out error: " + e.toString());
				}
				try {
					br.write((i) + "," + formula(i) + "\n");
				}
				catch(Exception e) {
					System.out.println("Write out error: " + e.toString());
				}
			}
			else {
				
				try {
					br.write((i) + "," + formula(i) + "\n");
				}
				catch(Exception e) {
					System.out.println("Write out error: " + e.toString());
				}
				
			}
		}
		try {
			br.close();
		}
		catch(Exception e) {
			System.out.println("Error: " + e.toString());
		}
		
	}
	
}
