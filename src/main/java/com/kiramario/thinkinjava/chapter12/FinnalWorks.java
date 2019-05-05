package com.kiramario.thinkinjava.chapter12;


class ThreeException extends Exception{}

public class FinnalWorks {
	static int count = 0;
	
	public static void main(String[] args){
		while(true){
			try{
				if(count++ == 0)
					throw new ThreeException();
				System.out.println("no exception");
			}catch(ThreeException e){
				System.out.println("ThreeException");
			}finally{
				System.out.println("in finnal cauee");
				if(count==2)
					break;
			}
		}
	}
}
