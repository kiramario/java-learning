package com.kiramario.thinkinjava.chapter12;

public class ReThrow {
	
	public static void f() throws Exception{
		System.out.println("orginating the exception in f()");
		throw new Exception("throw in f()");
	}
	
	public static void g() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("Inside g(), printStackTrace");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	public static void h() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("Inside h(), printStackTrace");
			e.printStackTrace(System.out);
			throw (Exception) e.fillInStackTrace();
		}
	}
	
	public static void main(String[] args){
		try{
			g();
		}catch(Exception e){
			System.out.println("main: printStackTrace:");
			e.printStackTrace(System.out);
		}
		System.out.println("============================");
		try{
			h();
		}catch(Exception e){
			System.out.println("main: printStackTrace:");
			e.printStackTrace(System.out);
		}
	}
}
