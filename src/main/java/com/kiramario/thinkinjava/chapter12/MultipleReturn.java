package com.kiramario.thinkinjava.chapter12;

public class MultipleReturn {
	public static void f(int i){
		System.out.println("Initialization that requires clean up");
		try{
			System.out.println("Point 1");
			if (i==1) return;
			System.out.println("Point 2");
			if (i==2) return;
			System.out.println("Point 3");
			if (i==3) return;
			System.out.println("end");
			return;
		}finally{
			System.out.println("Perform clean up");
		}
	}
	
	public static void main(String[] args){
		for(int i = 1; i <= 4; i++){
			f(i);
		}
	}
}
