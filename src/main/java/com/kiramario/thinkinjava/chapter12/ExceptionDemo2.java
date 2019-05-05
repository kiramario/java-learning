package com.kiramario.thinkinjava.chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MyException extends Exception{
	private int x;
	public MyException(){}
	public MyException(String msg){
		super(msg);
	}
	public MyException(String msg,int x){
		super(msg);
		this.x = x;
	}
	
	public int val(){
		return this.x;
	}
	
	@Override
	public String getMessage(){
		return "Detail Message " + x + " " + super.getMessage();
	}
}

public class ExceptionDemo2 {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionDemo2.class);
	public static void f() throws Exception{
		throw new MyException();
	}
	public static void g() throws Exception{
		throw new MyException("Orignate in g()");
	}
	public static void h() throws Exception{
		throw new MyException("Orignate in h()",111);
	}
	
	public static void main(String[] args){
		try{
			h();
		}catch(Exception e){
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			logger.error(sw.toString());
		}
	}
}
