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
		
		for(int n = 0;n<l;n++) {
			arraylist.set(0, arraylist.get(0)+1);
			
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
	
	public void subtract(int l) {
		
		for(int n = 0;n<l;n++) {
			arraylist.set(0, arraylist.get(0)-1);
			
			for(int i = 0;i<arraylist.size();i++) {
				
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
	
	
	public boolean devidedby(Number number) {
		
		Number numberconstant = number;
		System.out.println(number.arraylist.get(0));
		System.out.println(numberconstant.arraylist.get(0));
		System.out.println();
		
		
		while(true) {
			//checking if the arrays became the same
			
			
			number.print();
			if(arraylist.size()==number.arraylist.size()) {
				boolean same = true;
				for(int i = arraylist.size();i>0;i--) {
					if(number.arraylist.get(i)!=arraylist.get(i)) {
						same = false;
					}
					else if(number.arraylist.get(i)>arraylist.get(i)) {
						return false;
					}
					
				}
				if(same) {
					return true;
				}
			}
			
			
			
			
			// adding the number to itself
			for(int i = 0;i<numberconstant.arraylist.size();i++) {
				int m = numberconstant.arraylist.get(i);
				//for(int n = 0;n<i;n++)m=m*10;
				System.out.println(m);
				number.add(m);
			}
			
			
		}
		//return false;
	}
	
	
	public void print() {
		System.out.println();
		for(int i = arraylist.size()-1;i>=0;i--) {
			System.out.print(arraylist.get(i));
		}
	}
	
	public boolean simplecheck() {
		
		//cheking for 3s
		
		int sum = 0;
		for(int i = 0;i<arraylist.size();i++) {
			sum = sum+arraylist.get(i);
		}
		if(sum%3==0)return false;
		
		
		
		//cheking for 5s
		
		if(arraylist.get(0)==5)return false;
		
		
		
		//cheking for 7s
		
		ArrayList<Integer> samplearray = new ArrayList<Integer>();
		for(int i = 1;i<arraylist.size();i++) {
			samplearray.add(arraylist.get(i));
		}
		int difference = arraylist.get(0)*2;
		Number sample = new Number(samplearray);
		sample.subtract(difference);
		
		
		
		
		
		
		
		return true;
		
	}
	
	public boolean deepcheck() {
		
		
		
		
		return false;
		
	}
}
