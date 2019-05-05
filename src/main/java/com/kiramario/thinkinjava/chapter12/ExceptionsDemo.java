package com.kiramario.thinkinjava.chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SimpleException extends Exception{
	private static final Logger logger = LoggerFactory.getLogger(SimpleException.class);
	public SimpleException(){
		StringWriter sw = new StringWriter();
		printStackTrace(new PrintWriter(sw));
		logger.error(sw.toString());
	}
	public SimpleException(String msg){
		super(msg);
		StringWriter sw = new StringWriter();
		printStackTrace(new PrintWriter(sw));
		logger.error(sw.toString());
	}
}




public class ExceptionsDemo {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionsDemo.class);
	public void f() throws SimpleException{
		throw new SimpleException();
	}
	public void f2() throws SimpleException{
		throw new SimpleException("i am exception 2");
	}
	public static void main(String[] args){
		ExceptionsDemo ex = new ExceptionsDemo();
		try{
			ex.f();
		}catch(Exception e){
			StringWriter sw  = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			logger.error(sw.toString());;
		}
		try{
			ex.f2();
		}catch(Exception e){
			StringWriter sw  = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			logger.error(sw.toString());;
		}
		
	}
}
