import java.util.ArrayList;
import java.util.Arrays;

public class SetOperationTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7, 12));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		SetOperation setOp = new SetOperation(list1, list2);
		setOp.sim();
		

	}

}
