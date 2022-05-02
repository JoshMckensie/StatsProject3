import java.util.Random;

public class Person {

	private String bday;
	private Random rand;
	private int day;
	private int month;
	
	public Person() {
		day = 0;
		month = 0;
		bday = "";
		rand = new Random();
	}
	public String getBday() {
		return bday;
	}
	public void setBday(String bd) {
		bday = bd;
	}
	public void setDay(int d) {
		day = d;
	}
	public void setMonth(int m) {
		month = m;
	}
	public void randomMonth() {
		setMonth(1 + rand.nextInt(12));
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public void randomDay(int month) {
		
		if (month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			
			setDay(1 + rand.nextInt(31));
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			
			setDay(1 + rand.nextInt(30));
		}
		else {
			setDay(rand.nextInt(28));
		}
	}
	public void concat(int m, int d) {
		
		String month = String.valueOf(m);
		String day = String.valueOf(d);
		
		String birthday = (month + "/" + day);
		
		setBday(birthday);
		
	}
	public String createPerson() {
		
		randomMonth();
		randomDay(getMonth());
		concat(getMonth(), getDay());
		return (getBday());
		
		
	}
	
	
}
