package com.kiramario.multithreading;

class MyRunnable implements Runnable{
	private int cl = 0;
	@Override
	public void run() {
		synchronized(this){
			try{
				for(int i = 0; i < 5; i++){
					cl++;
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + " loop " + i +"; cl = " + cl);  
				}
			}catch(InterruptedException e){}
		}
	}
	
}


class Mythread2 extends Thread{
	private int cl = 0;
	public Mythread2(String name){
		super(name);
	}
	@Override
	public void run() {
		synchronized(this){
			try{
				for(int i = 0; i < 5; i++){
					cl++;
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + " loop " + i +"; cl = " + cl);  
				}
			}catch(InterruptedException e){}
		}
	}
	
}

public class SychronizedDemo_1 {
	public static void main(String[] args) { 
		Runnable runnable = new MyRunnable();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		
		t1.start();
		t2.start();
		
		/*Thread t1 = new Mythread2("m-1");
		Thread t2 = new Mythread2("m-2");
		t1.start();
		t2.start();*/
	}
}
