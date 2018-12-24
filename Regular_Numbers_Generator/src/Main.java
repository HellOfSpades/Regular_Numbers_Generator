import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Number> regular_list = new ArrayList<Number>();
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(3);
		list1.add(1);
		Number change = new Number(list1);
		change.print();
		
		while(true) {
			change.add(2);
			if(change.simplecheck() && change.deepcheck(regular_list)) {
				change.print();
				regular_list.add(new Number((ArrayList<Integer>) change.arraylist.clone()));
			}
		}
		
	}

}
