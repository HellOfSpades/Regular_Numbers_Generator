import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//delcaring the control variable that is going to be the number we will be changing
		//we start a 23 because we allready know all of the normal numbers before it
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(2);
		Number current_number = new Number(list);
		ArrayList<Number> answers = new ArrayList<Number>();
		
		
		
		ArrayList<Integer> example = new ArrayList<Integer>();
		example.add(5);
		System.out.println(current_number.devidedby(new Number(example)));
		
		
		
		//current_number.print();
		//for(int i = 0;i<100;i++) {
			//add two values to the control variable so that we skip all numbers that can divide by two
			//current_number.add(2);
			
			
		//}
		//current_number.print();
		
		
		
		//while(true) {
			
		//}
	}

}
