import java.util.ArrayList;

public class Number {

	ArrayList<Integer> arraylist;
	
	Number(){
		arraylist = new ArrayList<Integer>();
	}
	
	Number(ArrayList<Integer> arraylist){
		this.arraylist = arraylist;
	}
	
	public void add(int l) {
		
		// add ones to our number l amount of times
		
		for(int n = 0;n<l;n++) {
			arraylist.set(0, arraylist.get(0)+1);
			
			// if any of the digits are ever bigger than or equal to 10
			// than it sets it to 0 and gives plus one to the digit above it
			for(int i = 0;i<arraylist.size();i++) {
				if(arraylist.get(i)>=10) {
					arraylist.set(i, 0);
					if(i==arraylist.size()-1) {
						arraylist.add(1);
					}
					else {
						arraylist.set(i+1, arraylist.get(i+1)+1);
					}
				}
				else {
					break;
				}
			}
		}
	}
	
	// rather than adding zero digit numbers this method can add them to any of the digits
	public void add_to_digit(int l, int digit) {
		
		// add ones to our number l amount of times
		
		for(int n = 0;n<l;n++) {
			arraylist.set(digit, arraylist.get(digit)+1);
			
			// the digit which we change is the one we start with
			// if any of the digits are ever bigger than or equal to 10
			// than it sets it to 0 and gives plus one to the digit above it
			
			for(int i = digit;i<arraylist.size();i++) {
				if(arraylist.get(i)>=10) {
					arraylist.set(i, 0);
					
					if(i==arraylist.size()-1) {
						arraylist.add(1);
					}
					else {
						arraylist.set(i+1, arraylist.get(i+1)+1);
					}
				}
				else {
					break;
				}
			}
			
		}
	}
	
	public void subtract(int l) {
		
		// subtract ones from our number l amount of times
		
		for(int n = 0;n<l;n++) {
			arraylist.set(0, arraylist.get(0)-1);
			
			for(int i = 0;i<arraylist.size();i++) {
				// the loop subtracts numbers from each of the digits until all of them are positive
				// if a digit is negative than it will set itself to 10 - that digit and subtract 1 from the digit above
				// it does not support negative numbers
				if(arraylist.get(i)<0) {
					arraylist.set(i, 10+arraylist.get(i));
					if(i!=arraylist.size()-1) {
						arraylist.set(i+1, arraylist.get(i+1)-1);
					}
					else {
						System.out.println("class number does not support negetive numbers");
					}
				}
				else {
					break;
				}
				
			}
		}
	}
	
	public void clean() {
		for(int i = this.arraylist.size()-1;i>=0;i--) {
			if(this.arraylist.get(i)==0) {
				this.arraylist.remove(i);
			}
			else {
				break;
			}
		}
	}
	
	
	public int bigger_than(Number number) {
		
		// 2 means this number is bigger
		// 1 means they are the same
		// 0 means that the input number is bigger
		
		// if the input number has less digits than our number than it must be smaller
		if(number.arraylist.size()<this.arraylist.size()) {
			return 2;
		}
		else if(number.arraylist.size()==this.arraylist.size()) {
			
			// we check from the largest digits to the smallest
			// the first one to be bigger or smaller decides which one is
			
			for(int i = number.arraylist.size()-1;i>=0;i--) {
				if(this.arraylist.get(i)<number.arraylist.get(i)) {
					return 0;
				}
				else if(this.arraylist.get(i)>number.arraylist.get(i)) {
					return 2;
				}
			}
		}
		else {
			// if our number has less digits than the input number than it is smaller
			return 0;
		}
		
		// if the "else if" statement doesn't return anything than it must be the same
		return 1;
		
	}
	
	
	public boolean devidedby(Number number) {
		
		Number numbercon = new Number((ArrayList<Integer>) number.arraylist.clone());
		
		// it adds number to a copy of number until it is greater or same as our number
		// if it is greater than it can't be divided, if same that it can
		
		while(true) {
			int check = numbercon.bigger_than(this);
			if(check==2) {
				return false;
			}
			else if(check==1) {
				return true;
			}
			else {
				for(int i = 0;i<number.arraylist.size();i++) {
					numbercon.add_to_digit(number.arraylist.get(i), i);
				}
			}
		}
	}
	
	
	public void print() {
		
		for(int i = arraylist.size()-1;i>=0;i--) {
			System.out.print(arraylist.get(i));
		}
		System.out.println();
	}
	
	
	// check numbers that accrue very often and that will
	public boolean simplecheck() {
		
		//Checking for 3s
		
		int sum = 0;
		for(int i = 0;i<arraylist.size();i++) {
			sum = sum+arraylist.get(i);
		}
		if(sum%3==0) {
			//System.out.println("it was 3");
			return false;
		}
		
		
		
		//Checking for 5s
		
		if(arraylist.get(0)==5) {
			//System.out.println("it was 5");
			return false;
		}
		
		
		
		//checking for 7s
		// first we make a copy of our array so that our array is not damaged
		ArrayList<Integer> samplearray = new ArrayList<Integer>();
		for(int i = 0;i<arraylist.size();i++) {
			samplearray.add(arraylist.get(i));
		}
		Number sample = new Number(samplearray);
		// we use the sign of the number being divisible by 7 to then check it
		// we decrease it until it is 3 decimals so that we have
		// 2345 -> 234-(5*2) -> if(224%7==0)
		while(sample.arraylist.size()>3) {
			int i = sample.arraylist.get(0);
			sample.arraylist.remove(0);
			sample.subtract(i*2);
			sample.clean();
		}
		ArrayList<Integer> deviderarray = new ArrayList<Integer>();
		deviderarray.add(7);
		Number devider = new Number(deviderarray);
		if(sample.devidedby(devider)) {
			//System.out.println("it was 7");
			return false;
		}
		
		
		
		//checking for 11s
		// 69845 -> 6-9+8-4+5 -> 6 -> if(6%11==0)
		sum = 0;
		boolean adding = true;
		for(int i = this.arraylist.size()-1;i>=0;i--) {
			if(adding) {
				sum = sum+this.arraylist.get(i);
			}
			else {
				sum = sum-this.arraylist.get(i);
			}
			adding = !adding;
		}
		if(sum%11==0) {
			//System.out.println("it was 11");
			return false;
		}
		
		
		
		//checking for 13s
		// rather than making a new variable to represent a copy of our array we can use the same one as before
		samplearray = new ArrayList<Integer>();
		for(int i = 0;i<arraylist.size();i++) {
			samplearray.add(arraylist.get(i));
		}
		sample = new Number(samplearray);
		// we use the sign of the number being divisible by 13 to then check it
		// 344546 -> 34454+(6*4) -> i -> if(i%13==0)
		while(sample.arraylist.size()>3) {
			int i = sample.arraylist.get(0);
			sample.arraylist.remove(0);
			sample.add(i*4);
			sample.clean();
		}
		deviderarray = new ArrayList<Integer>();
		deviderarray.add(3);
		deviderarray.add(1);
		devider = new Number(deviderarray);
		//sample.print();
		if(sample.devidedby(devider)) {
			//System.out.println("it was 13");
			return false;
		}
		
		
				
		// it none of the previous checks work than it is not divided by any of the previous numbers
		return true;
		
	}
	
	// checks if this number can be divided by the other regular numbers found before
	// the other numbers are given in an array list
	public boolean deepcheck(ArrayList<Number> number) {
		
		for(int i = 0;i<number.size();i++) {
			if(this.devidedby(number.get(i))) {
				return false;
			}
		}
		
		
		return true;
		
	}
}
