
public class MeanMedModeSd {

	private int[] arr;
	
	public MeanMedModeSd(int[] arr) {
		
		this.arr = arr;
	}
	
	public int[] getArr() {
		return arr;
	}


	public void setArr(int[] arr) {
		this.arr = arr;
	}


	public double mean(int[] arr) {
		
		int[] sorted;
		sorted = arraySort(arr);
		double total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += sorted[i];
		}
		return total / sorted.length;
	}
	
	public int[] arraySort(int[] arr) {
		
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
		
	}
	
	public int median(int[] arr) {
		
		int median;
		int[] sorted;
		sorted = arraySort(arr);
		
		if (sorted.length % 2 != 0) {
			int middle = sorted.length / 2;
			median = sorted[middle];
		}
		else {
			int middle1 = sorted.length / 2;
			int middle2 = middle1 - 1;
			median = (sorted[middle1] + sorted[middle2]) / 2; 
		}
		return median;
		
	}
	public int mode(int[] arr) {
		
		int maxValue = 0, maxCount = 0, i, j;

	      for (i = 0; i < arr.length; ++i) {
	         int count = 0;
	         for (j = 0; j < arr.length; ++j) {
	            if (arr[j] == arr[i])
	            ++count;
	         }

	         if (count > maxCount) {
	            maxCount = count;
	            maxValue = arr[i];
	         }
	      }
	      return maxValue;
	}
	public double sd(int[] numbers) {
		
		if (numbers.length == 1) {
			return 1;
		}
		if (numbers.length == 0) {
			return 0;
		}
		double mean = 0;
		for (int i = 0; i < numbers.length; i++) {
			mean += numbers[i];
		}
		mean = mean / numbers.length;
		double sumOfTempVal = 0;
		for (int i = 0; i < numbers.length; i++) {
			double tempVal = Math.pow(mean - numbers[i], 2);
			sumOfTempVal += tempVal;
		}
		double result = sumOfTempVal / (numbers.length - 1);
		
		return Math.sqrt(result);
	}
	public void calculate() {
		
		System.out.println("Mean: " + mean(getArr()));
		System.out.println("Median: " + median(getArr()));
		System.out.println("Mode: " + mode(getArr()));
		System.out.println("Standard Deviation: " + sd(getArr()));
		
	}
	
}
