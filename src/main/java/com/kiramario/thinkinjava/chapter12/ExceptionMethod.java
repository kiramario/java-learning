package com.kiramario.thinkinjava.chapter12;

public class ExceptionMethod {
	public static void main(String[] args){
		
		/*try{
			throw new Exception("my exception");
			
		}catch(Exception e){
			System.out.println("getMessage: " + e.getMessage());
			System.out.println("getLocalizedMessage: " + e.getLocalizedMessage());
			System.out.println("toString: " + e);
			System.out.println("printStackTrace: ");
			e.printStackTrace(System.out);
		}*/
		try{
			TRD.ttr();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}


class TRD{
	public static String ttr(){
		return tr();
	}
	public static String tr(){
		try{
			throw new RuntimeException("Exception 1");
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw new RuntimeException("Exception 2");
		}
		
	}
}
