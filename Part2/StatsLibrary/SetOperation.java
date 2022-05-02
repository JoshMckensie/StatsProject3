import java.util.ArrayList;
import java.util.Arrays;

public class SetOperation {

	private ArrayList<Integer> arrList1;
	private ArrayList<Integer> arrList2;
	
	public SetOperation(ArrayList<Integer> arrList1, ArrayList<Integer> arrList2) {
		
		this.arrList1 = new ArrayList<>(arrList1);
		this.arrList2 = new ArrayList<>(arrList2);
		
	}
	
	
	public ArrayList<Integer> getArrList1() {
		return arrList1;
	}


	public void setArrList1(ArrayList<Integer> arrList1) {
		this.arrList1 = arrList1;
	}


	public ArrayList<Integer> getArrList2() {
		return arrList2;
	}


	public void setArrList2(ArrayList<Integer> arrList2) {
		this.arrList2 = arrList2;
	}


	public ArrayList<Integer> compliment(ArrayList<Integer> list){
		
		ArrayList<Integer> oddNumsToNine = new ArrayList<>(Arrays.asList(1,3, 5, 7, 9));
		ArrayList<Integer> compList = new ArrayList<>();
		
		for (int i = 0; i < oddNumsToNine.size(); i++) {
			
			if (!list.contains(oddNumsToNine.get(i))) {
				compList.add(oddNumsToNine.get(i));
			}
			
		}
		
		return compList;
		
	}
	
	public ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2){
		
		ArrayList<Integer> intersectList = new ArrayList<>();
		
		if (list1.size() <= list2.size()) {
			
			for (int i = 0; i < list1.size(); i++) {
				if (list2.contains(list1.get(i))) {
					intersectList.add(list1.get(i));
				}
			}
		}
		else {
			
			for (int i = 0; i < list2.size(); i++) {
				if (list1.contains(list2.get(i))) {
					intersectList.add(list2.get(i));
				}
			}
		}
		
		
		return intersectList;
		
	}
	
	public ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2){
		
		ArrayList<Integer> unionList = new ArrayList<>(list2);
		for (int i = 0; i < list1.size(); i++) {
			if (!list2.contains(list1.get(i))) {
				unionList.add(list1.get(i));
			}
		}
		
		return unionList;
	}
	public void sim() {
		
		System.out.println("Compliment: " + compliment(getArrList1()));
		System.out.println("Intersect: " + intersect(getArrList1(), getArrList2()));
		System.out.println("Union: " + union(getArrList1(), getArrList2()));
		
	}
	
}
