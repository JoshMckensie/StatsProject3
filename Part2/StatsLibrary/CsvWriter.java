import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class CsvWriter {

	private FileWriter fw;
	private BufferedWriter br;
	private Random rng;
	
	public CsvWriter() {
		try {
			fw = new FileWriter("FavoriteNum.csv");
			rng = new Random();
		}
		catch(Exception e) {
			System.out.println("ERROR: " + e.toString());
		}
	}
	public int randomNum() {
		int x = 1 + rng.nextInt(999);
		return x;
	}
	public void singleLine(){
		br = new BufferedWriter(fw);
		String header = "ID, Fav Num\n";
		for (int i = 0; i <= 1000; i++) {
			if (i == 0) {
				
				try {
					br.write(header);
				}
				catch(Exception e) {
					System.out.println("Write out error: " + e.toString());
				}
				
			}
			else {
				
				try {
					br.write((i) + "," + randomNum() + "\n");
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
