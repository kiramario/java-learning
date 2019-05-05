package com.kiramario.multithreading;

public class SynchronizedDemo3 {
	
	public synchronized void synMethod(){
		 for(int i=0; i<100000000; i++)
			 ;
	}
	
	public  void synBlock(){
		synchronized(this){
			for(int i=0; i<100000000; i++)
				 ;
		}
			
	}
	
	public static void main(String[] args){
		SynchronizedDemo3 d = new SynchronizedDemo3();
		long start , diff;
		start = System.currentTimeMillis();
		d.synMethod();
		diff = System.currentTimeMillis() - start;
		System.out.println("synMethod() : "+ diff);
		
		
		start = System.currentTimeMillis();
		d.synBlock();
		diff = System.currentTimeMillis() - start;
		System.out.println("synBlock() : "+ diff);
		
	}
}
